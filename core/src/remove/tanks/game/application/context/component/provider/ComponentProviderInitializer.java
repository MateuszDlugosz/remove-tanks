package remove.tanks.game.application.context.component.provider;

import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierInitializer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierScanner;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentProviderInitializer {
    private static final Logger LOGGER = Logger.getLogger(ComponentProviderInitializer.class.getName());

    private final ComponentProviderFactory componentProviderFactory;
    private final ComponentSupplierInitializer componentSupplierInitializer;
    private final ComponentSupplierScanner componentSupplierScanner;

    public ComponentProviderInitializer(
            ComponentProviderFactory componentProviderFactory,
            ComponentSupplierInitializer componentSupplierInitializer,
            ComponentSupplierScanner componentSupplierScanner
    ) {
        this.componentProviderFactory = componentProviderFactory;
        this.componentSupplierInitializer = componentSupplierInitializer;
        this.componentSupplierScanner = componentSupplierScanner;
    }

    public Map<String, ComponentProvider> initializeComponentProviders(String packageName, Context context) {
        try {
            return initializeComponentProviders(componentSupplierScanner.scanPackage(packageName), context);
        } catch (Exception e) {
            throw new ComponentProviderInitializationException(e);
        }
    }

    private Map<String, ComponentProvider> initializeComponentProviders(Set<Class<? extends ComponentSupplier>> supplierClasses, Context context) {
        try {
            return supplierClasses.stream()
                    .map(c -> {
                        ComponentSupplier supplier = componentSupplierInitializer.initializeComponentSupplier(c, context);
                        LOGGER.info(String.format("'%s' component provider initialized from class '%s' with scope '%s'.",
                                supplier.getComponentName(), c.toString(), supplier.getComponentScope()));
                        return supplier;
                    })
                    .collect(Collectors.toMap(
                            ComponentSupplier::getComponentName,
                            componentProviderFactory::createComponentProvider
                    ));
        } catch (IllegalStateException e) {
            throw new DuplicateKeyException(e);
        }
    }
}
