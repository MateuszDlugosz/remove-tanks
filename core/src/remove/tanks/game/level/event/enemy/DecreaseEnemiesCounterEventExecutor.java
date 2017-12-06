package remove.tanks.game.level.event.enemy;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class DecreaseEnemiesCounterEventExecutor
        implements RegistrableEventExecutor<DecreaseEnemiesCounterEvent>
{
    @Override
    public void executeEvent(DecreaseEnemiesCounterEvent event, Level level) {
        Properties properties = level.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class);
        if (properties.getInt(LevelProperty.LevelEnemies.getName()) > 0) {
            properties.putInt(
                    LevelProperty.LevelEnemies.getName(),
                    properties.getInt(LevelProperty.LevelEnemies.getName()) - 1
            );
        }
    }

    @Override
    public Class<DecreaseEnemiesCounterEvent> getExecutorType() {
        return DecreaseEnemiesCounterEvent.class;
    }
}
