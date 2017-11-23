package remove.tanks.game.configuration.component.utilities;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.constant.ConfigurationKey;
import remove.tanks.game.utility.scale.DividingScale;
import remove.tanks.game.utility.scale.MultiplyingScale;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ScaleSupplierConfiguration {
    @ComponentName("WorldScale")
    public static final class WorldScaleSupplier extends ComponentSupplier<Scale> {
        @Override
        public Scale supplyComponent() {
            return new DividingScale(Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameLevelWorldScale.getKey())));
        }
    }

    @ComponentName("DisplayScale")
    public static final class DisplayScaleSupplier extends ComponentSupplier<Scale> {
        @Override
        public Scale supplyComponent() {
            return new MultiplyingScale(Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayScale.getKey())));
        }
    }
}
