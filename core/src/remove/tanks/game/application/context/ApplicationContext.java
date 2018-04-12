package remove.tanks.game.application.context;

import com.google.common.collect.ImmutableMap;
import remove.tanks.game.application.context.component.provider.*;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierInitializer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierScanner;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassConstructorValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassModifierValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassValidator;
import remove.tanks.game.application.context.component.supplier.validator.SubComponentSupplierValidator;
import remove.tanks.game.application.context.configuration.Configuration;

import java.util.logging.Logger;

/**
 * @author Mateusz Długosz
 */
public final class ApplicationContext implements Context {
    public static final String COMPONENT_CONFIGURATION_PACKAGE_OPTION = "component.configuration.package";

    private static final Logger LOGGER = Logger.getLogger(ApplicationContext.class.getName());
    private final Configuration configuration;

    private final ImmutableMap<String, ComponentProvider> providers;

    public ApplicationContext(Configuration configuration) throws ContextInitializationException {
        try {
            ComponentProviderInitializer componentProviderInitializer = new ComponentProviderInitializer(
                    new ComponentProviderFactory(
                            new SubComponentProviderFactory[]{
                                    new SingletonComponentProviderFactory(),
                                    new PrototypeComponentProviderFactory()
                            }
                    ),
                    new ComponentSupplierInitializer(
                            new ComponentSupplierClassValidator(
                                    new SubComponentSupplierValidator[]{
                                            new ComponentSupplierClassModifierValidator(),
                                            new ComponentSupplierClassConstructorValidator()
                                    }
                            )
                    ),
                    new ComponentSupplierScanner()
            );
            ImmutableMap.Builder<String, ComponentProvider> builder = ImmutableMap.builder();
            String componentPackages = configuration.getOption(COMPONENT_CONFIGURATION_PACKAGE_OPTION);
            long time = System.currentTimeMillis();
            this.configuration = configuration;

            LOGGER.info("Application context initialization started.");
            LOGGER.info(String.format("Application context creating providers from package '%s' started.", componentPackages));
            builder.putAll(componentProviderInitializer.initializeComponentProviders(componentPackages, this));
            LOGGER.info(String.format("Application context creating providers from package '%s' ended.", componentPackages));

            providers = builder.build();
            providers.values().forEach(p -> {
                if (p instanceof SingletonComponentProvider) {
                    p.provideComponent();
                }
            });

            LOGGER.info(String.format("Application context initialized %s components.", providers.size()));
            LOGGER.info(String.format("Application context initialization ended. (%s ms)",
                    System.currentTimeMillis() - time));
        } catch (Exception e) {
            throw new ContextInitializationException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getComponent(Class<T> type) {
        if (!providers.containsKey(type.toString())) {
            throw new ComponentProviderNotFoundException(type.toString());
        }
        return (T) providers.get(type.toString()).provideComponent();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getComponent(String name, Class<T> type) {
        if (!providers.containsKey(name)) {
            throw new ComponentProviderNotFoundException(name);
        }
        return (T) providers.get(name).provideComponent();
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
