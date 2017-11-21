package remove.tanks.game.configuration.component.level;

import remove.tanks.game.application.context.component.provider.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentScope;
import remove.tanks.game.level.input.InputMapper;

/**
 * @author Mateusz Długosz
 */
public final class InputSupplierConfiguration {
    @ComponentName("InputMapper")
    @ComponentScope(Scope.Prototype)
    public static final class InputMapperSupplier extends ComponentSupplier<InputMapper> {
        @Override
        public InputMapper supplyComponent() {
            return new InputMapper();
        }
    }
}
