package remove.tanks.game.application.context.component.supplier.test_package;

import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentScope;

/**
 * @author Mateusz Długosz
 */
public final class TestComponentSupplierBag {
    public static final String PACKAGE_NAME = "remove.tanks.game.application.context.component.supplier.test_package";

    public static final String COMPONENT_0_NAME = "test-name-0";
    public static final String COMPONENT_1_NAME = "test-name-1";

    public static final Scope COMPONENT_0_SCOPE = Scope.Singleton;
    public static final Scope COMPONENT_1_SCOPE = Scope.Prototype;

    public static final Class<?> COMPONENT_0_CLASS = String.class;
    public static final Class<?> COMPONENT_1_CLASS = Integer.class;

    public static final String TEST_SUPPLIER_0_INITIAL_VALUE = "test-supplier-0";
    public static final int TEST_SUPPLIER_1_INITIAL_VALUE = 0;

    @ComponentName("test-name-0")
    @ComponentScope(Scope.Singleton)
    public static final class TestComponentSupplier_0 extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return TEST_SUPPLIER_0_INITIAL_VALUE;
        }
    }

    @ComponentName("test-name-1")
    @ComponentScope(Scope.Prototype)
    public static final class TestComponentSupplier_1 extends ComponentSupplier<Integer> {
        private final int number = TEST_SUPPLIER_1_INITIAL_VALUE;

        @Override
        public Integer supplyComponent() {
            return number;
        }
    }
}
