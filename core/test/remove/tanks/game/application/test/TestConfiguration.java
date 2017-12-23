package remove.tanks.game.application.test;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class TestConfiguration {
    @ComponentName("StringTest")
    public static final class StringSupplier extends ComponentSupplier<String> {
        @Override
        public String supplyComponent() {
            return "test-value";
        }
    }

    @ComponentName("IntegerTest")
    public static final class IntegerSupplier extends ComponentSupplier<Integer> {
        @Override
        public Integer supplyComponent() {
            return 10;
        }
    }
}
