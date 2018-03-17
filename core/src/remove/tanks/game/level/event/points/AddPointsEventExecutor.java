package remove.tanks.game.level.event.points;

import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventExecutor implements SubEventExecutor<AddPointsEvent> {
    @Override
    public void executeEvent(AddPointsEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .putInt(
                            LevelProperty.LevelPoints.getName(),
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                                    .getInt(LevelProperty.LevelPoints.getName()) + event.getPoints()
                    );
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddPointsEvent> getExecutorType() {
        return AddPointsEvent.class;
    }
}
