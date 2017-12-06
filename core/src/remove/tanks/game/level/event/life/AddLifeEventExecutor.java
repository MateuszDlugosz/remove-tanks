package remove.tanks.game.level.event.life;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventExecutor
        implements RegistrableEventExecutor<AddLifeEvent>
{
    @Override
    public void executeEvent(AddLifeEvent event, Level level) {
        Properties properties = level.getResourceRegistry().getResource(LevelResource.Properties.toString(),
                Properties.class);
        properties.putInt(LevelProperty.LevelLifes.toString(),
                properties.getInt(LevelProperty.LevelLifes.toString()) + 1);
    }

    @Override
    public Class<AddLifeEvent> getExecutorType() {
        return null;
    }
}
