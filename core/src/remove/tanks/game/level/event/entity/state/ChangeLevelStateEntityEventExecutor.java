package remove.tanks.game.level.event.entity.state;

import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEntityEventExecutor implements SubEventExecutor<ChangeLevelStateEntityEvent> {
    @Override
    public void executeEvent(ChangeLevelStateEntityEvent event, ResourceRegistry registry) {
        try {
             registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                     .putString(LevelProperty.LevelState.getName(), event.getLevelState().getName());
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ChangeLevelStateEntityEvent> getExecutorType() {
        return ChangeLevelStateEntityEvent.class;
    }
}
