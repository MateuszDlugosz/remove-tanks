package remove.tanks.game.application.context.component.supplier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.component.supplier.test_package.TestComponentSupplierBag;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassConstructorValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassModifierValidator;
import remove.tanks.game.application.context.component.supplier.validator.ComponentSupplierClassValidator;
import remove.tanks.game.application.context.component.supplier.validator.SubComponentSupplierValidator;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationOption;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ComponentSupplierInitializerTest {
    private ComponentSupplierInitializer initializer;
    private Context context;

    @Before
    public void initTestObjects() {
        initializer = new ComponentSupplierInitializer(
                new ComponentSupplierClassValidator(
                        new SubComponentSupplierValidator[] {
                                new ComponentSupplierClassConstructorValidator(),
                                new ComponentSupplierClassModifierValidator()
                        }
                )
        );

        Map<String, String> options = new HashMap<>();
        options.put(
                ConfigurationOption.GameComponentConfigurationPackage.getName(),
                TestComponentSupplierBag.PACKAGE_NAME
        );

        Configuration configuration = new Configuration(options);
        LogManager.getLogManager().reset();
        context = new ApplicationContext(configuration);
    }

    @Test
    public void Should_ReturnComponentNamesFromAnnotations() {
        ComponentSupplier supplier_0 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_0.class, context);
        ComponentSupplier supplier_1 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_1.class, context);

        assertEquals(TestComponentSupplierBag.COMPONENT_0_NAME, supplier_0.getComponentName());
        assertEquals(TestComponentSupplierBag.COMPONENT_1_NAME, supplier_1.getComponentName());
    }

    @Test
    public void Should_ReturnComponentScopesFromAnnotations() {
        ComponentSupplier supplier_0 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_0.class, context);
        ComponentSupplier supplier_1 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_1.class, context);

        Assert.assertEquals(TestComponentSupplierBag.COMPONENT_0_SCOPE, supplier_0.getComponentScope());
        Assert.assertEquals(TestComponentSupplierBag.COMPONENT_1_SCOPE, supplier_1.getComponentScope());
    }

    @Test
    public void Should_ReturnValidComponentValues() {
        ComponentSupplier supplier_0 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_0.class, context);
        ComponentSupplier supplier_1 = initializer.initializeComponentSupplier(TestComponentSupplierBag.TestComponentSupplier_1.class, context);

        assertEquals(TestComponentSupplierBag.TEST_SUPPLIER_0_INITIAL_VALUE, supplier_0.supplyComponent());
        assertEquals(TestComponentSupplierBag.TEST_SUPPLIER_1_INITIAL_VALUE, supplier_1.supplyComponent());
    }
}