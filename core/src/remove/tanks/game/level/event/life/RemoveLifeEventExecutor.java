package remove.tanks.game.level.event.life;

import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventExecutor implements SubEventExecutor<RemoveLifeEvent> {
    @Override
    public void executeEvent(RemoveLifeEvent event, ResourceRegistry registry) {
        try {
            int newLifesCount = registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .getInt(LevelProperty.LevelLifes.getName()) - 1;

            if (newLifesCount >= 0) {
                registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                        .putInt(LevelProperty.LevelLifes.getName(), newLifesCount);
            }
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<RemoveLifeEvent> getExecutorType() {
        return RemoveLifeEvent.class;
    }
}
