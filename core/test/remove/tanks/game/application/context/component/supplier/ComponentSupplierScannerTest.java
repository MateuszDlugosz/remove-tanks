package remove.tanks.game.application.context.component.supplier;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.application.context.component.supplier.test_package.TestComponentSupplierBag;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class ComponentSupplierScannerTest {
    private ComponentSupplierScanner scanner;

    @Before
    public void initTestObjects() {
        scanner = new ComponentSupplierScanner();
    }

    @Test
    public void Should_ReturnAllComponentSupplierSubclassesInGivenPackage() {
        Set<Class<? extends ComponentSupplier>> supplierClasses = scanner.scanPackage(TestComponentSupplierBag.PACKAGE_NAME);

        assertEquals(2, supplierClasses.size());
        assertTrue(supplierClasses.contains(TestComponentSupplierBag.TestComponentSupplier_0.class));
        assertTrue(supplierClasses.contains(TestComponentSupplierBag.TestComponentSupplier_1.class));
    }
}