package remove.tanks.game.level.event.life;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventExecutor
        implements RegistrableEventExecutor<RemoveLifeEvent>
{
    @Override
    public void executeEvent(RemoveLifeEvent event, Level level) {
        Properties properties = level.getResourceRegistry().getResource(LevelResource.Properties.toString(),
                Properties.class);
        if (properties.getInt(LevelProperty.LevelLifes.getName()) > 0) {
            properties.putInt(LevelProperty.LevelLifes.getName(),
                    properties.getInt(LevelProperty.LevelLifes.getName()) - 1);
        }
    }

    @Override
    public Class<RemoveLifeEvent> getExecutorType() {
        return RemoveLifeEvent.class;
    }
}
