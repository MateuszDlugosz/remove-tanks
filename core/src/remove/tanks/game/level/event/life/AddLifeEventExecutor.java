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
public final class AddLifeEventExecutor implements SubEventExecutor<AddLifeEvent> {
    @Override
    public void executeEvent(AddLifeEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .putInt(LevelProperty.LevelLifes.getName(),
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                                    .getInt(LevelProperty.LevelLifes.getName()) + 1);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddLifeEvent> getExecutorType() {
        return AddLifeEvent.class;
    }
}
