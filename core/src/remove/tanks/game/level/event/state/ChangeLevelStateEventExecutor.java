package remove.tanks.game.level.event.state;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventExecutor
        implements RegistrableEventExecutor<ChangeLevelStateEvent>
{
    @Override
    public void executeEvent(ChangeLevelStateEvent event, Level level) {
        level.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                .putString(LevelProperty.LevelState.getName(), event.getLevelState().getName());
    }

    @Override
    public Class<ChangeLevelStateEvent> getExecutorType() {
        return ChangeLevelStateEvent.class;
    }
}
