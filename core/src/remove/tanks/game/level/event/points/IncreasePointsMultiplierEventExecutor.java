package remove.tanks.game.level.event.points;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventExecutor
        implements RegistrableEventExecutor<IncreasePointsMultiplierEvent>
{
    @Override
    public void executeEvent(IncreasePointsMultiplierEvent event, Level level) {
        Properties properties = level.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class);
        properties.putInt(
                LevelProperty.LevelPointsMultiplier.getName(),
                properties.getInt(LevelProperty.LevelPointsMultiplier.getName()) + 1
        );
    }

    @Override
    public Class<IncreasePointsMultiplierEvent> getExecutorType() {
        return IncreasePointsMultiplierEvent.class;
    }
}
