package remove.tanks.game.application.context;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.component.provider.ComponentProviderNotFoundException;
import remove.tanks.game.application.context.component.supplier.test_package.TestComponentSupplierBag;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationOption;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ApplicationContextTest {
    private static final String UNKNOWN_COMPONENT_NAME = "unknown-component";

    private Context context;

    @Before
    public void initTestObjects() {
        Map<String, String> options = new HashMap<>();
        options.put(
                ConfigurationOption.GameComponentConfigurationPackage.getName(),
                TestComponentSupplierBag.PACKAGE_NAME
        );

        LogManager.getLogManager().reset();

        context = new ApplicationContext(new Configuration(options));
    }

    @Test
    public void Should_ReturnCorrectClasses_When_ContextIsInitialized() {
        assertEquals(
                TestComponentSupplierBag.COMPONENT_0_CLASS,
                context.getComponent(
                        TestComponentSupplierBag.COMPONENT_0_NAME,
                        TestComponentSupplierBag.COMPONENT_0_CLASS
                ).getClass()
        );
        assertEquals(
                TestComponentSupplierBag.COMPONENT_1_CLASS,
                context.getComponent(
                        TestComponentSupplierBag.COMPONENT_1_NAME,
                        TestComponentSupplierBag.COMPONENT_1_CLASS
                ).getClass()
        );
    }

    @Test
    public void Should_ReturnCorrectValues_When_ContextIsInitialized() {
        assertEquals(
                TestComponentSupplierBag.TEST_SUPPLIER_0_INITIAL_VALUE,
                context.getComponent(
                        TestComponentSupplierBag.COMPONENT_0_NAME,
                        TestComponentSupplierBag.COMPONENT_0_CLASS
                )
        );
        assertEquals(
                TestComponentSupplierBag.TEST_SUPPLIER_1_INITIAL_VALUE,
                context.getComponent(
                        TestComponentSupplierBag.COMPONENT_1_NAME,
                        TestComponentSupplierBag.COMPONENT_1_CLASS
                )
        );
    }

    @Test(expected = ComponentProviderNotFoundException.class)
    public void Should_ThrowException_When_GivenComponentNameNotFound() {
        context.getComponent(UNKNOWN_COMPONENT_NAME);
    }
}