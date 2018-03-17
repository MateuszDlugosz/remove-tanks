package remove.tanks.game.configuration.component.utility;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.utility.scale.DividingScale;
import remove.tanks.game.utility.scale.MultiplyingScale;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ScaleConfiguration {
    @ComponentName("WorldScale")
    public static final class WorldScaleSupplier extends ComponentSupplier<Scale> {
        @Override
        public Scale supplyComponent() {
            return new DividingScale(Float.valueOf(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameWorldScale.getName())
            ));
        }
    }

    @ComponentName("UIScale")
    public static final class UIScaleSupplier extends ComponentSupplier<Scale> {
        @Override
        public Scale supplyComponent() {
            return new MultiplyingScale(Float.valueOf(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameUIScale.getName())
            ));
        }
    }
}
