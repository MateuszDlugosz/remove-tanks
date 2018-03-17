package remove.tanks.game.level.event.entity.points;

import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEntityEventExecutor implements SubEventExecutor<AddPointsEntityEvent> {
    @Override
    public void executeEvent(AddPointsEntityEvent event, ResourceRegistry registry) {
        try {
            int points = event.getPoints() * registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .getInt(LevelProperty.LevelPointsMultiplier.getName());
            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .putInt(
                            LevelProperty.LevelPoints.getName(),
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                                    .getInt(LevelProperty.LevelPoints.getName()) + points
                    );
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddPointsEntityEvent> getExecutorType() {
        return AddPointsEntityEvent.class;
    }
}
