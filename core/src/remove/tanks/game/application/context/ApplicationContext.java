package remove.tanks.game.application.context;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.google.common.collect.ImmutableMap;
import remove.tanks.game.application.context.component.provider.*;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierInitializer;
import remove.tanks.game.application.context.component.supplier.ComponentSupplierScanner;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassConstructorValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassModifierValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassValidator;
import remove.tanks.game.application.context.component.supplier.validator.RegistrableComponentSupplierValidator;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationXmlLoader;
import sun.awt.AppContext;

import java.util.logging.Logger;

/**
 * @author Mateusz Długosz
 */
public final class ApplicationContext implements Context {
    private static final Logger LOGGER = Logger.getLogger(ApplicationContext.class.getName());
    private final Configuration configuration;

    private final ComponentProviderInitializer componentProviderInitializer
            = new ComponentProviderInitializer(
            new ComponentProviderFactory(
                    new RegistrableComponentProviderFactory[] {
                            new SingletonComponentProviderFactory(),
                            new PrototypeComponentProviderFactory()
                    }
            ),
            new ComponentSupplierInitializer(
                    new ComponentSupplierClassValidator(
                            new RegistrableComponentSupplierValidator[] {
                                    new ComponentSupplierClassModifierValidator(),
                                    new ComponentSupplierClassConstructorValidator()
                            }
                    )
            ),
            new ComponentSupplierScanner()
    );

    private final ImmutableMap<String, ComponentProvider> providers;

    public ApplicationContext(Configuration configuration) {
        this.configuration = configuration;

        LOGGER.info("Application context initialization started.");
        ImmutableMap.Builder<String, ComponentProvider> builder = ImmutableMap.builder();

        for (String packageName : this.configuration.getComponentSupplierPackages()) {
            LOGGER.info(String.format("Application context creating providers from package '%s' started.", packageName));
            builder.putAll(componentProviderInitializer.initializeComponentProviders(packageName, this));
            LOGGER.info(String.format("Application context creating providers from package '%s' ended.", packageName));
        }

        providers = builder.build();
        providers.values().forEach(p -> {
            if (p instanceof SingletonComponentProvider) {
                p.provideComponent();
            }
        });

        LOGGER.info("Application context initialization ended.");
    }

    @Override
    public Object getComponent(String name) {
        if (!providers.containsKey(name)) {
            throw new ComponentProviderNotFoundException(name);
        }
        return providers.get(name).provideComponent();
    }

    @Override
    public <T> T getComponent(Class<T> type) {
        if (!providers.containsKey(type.toString())) {
            throw new ComponentProviderNotFoundException(type.toString());
        }
        return (T) providers.get(type.toString()).provideComponent();
    }

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
