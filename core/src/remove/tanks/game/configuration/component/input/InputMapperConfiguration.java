package remove.tanks.game.configuration.component.input;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.input.InputMapperFactory;

/**
 * @author Mateusz Długosz
 */
public final class InputMapperConfiguration {
    @ComponentName("InputMapperFactory")
    public static final class InputMapperFactorySupplier extends ComponentSupplier<InputMapperFactory> {
        @Override
        public InputMapperFactory supplyComponent() {
            return new InputMapperFactory();
        }
    }

    @ComponentName("InputMapper")
    public static final class InputMapperSupplier extends ComponentSupplier<InputMapper> {
        @Override
        public InputMapper supplyComponent() {
            return getContext().getComponent("InputMapperFactory", InputMapperFactory.class)
                    .createInputMapper();
        }
    }
}
