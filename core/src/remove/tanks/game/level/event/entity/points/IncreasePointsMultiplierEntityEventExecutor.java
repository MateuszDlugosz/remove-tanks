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
public final class IncreasePointsMultiplierEntityEventExecutor implements SubEventExecutor<IncreasePointsMultiplierEntityEvent> {
    @Override
    public void executeEvent(IncreasePointsMultiplierEntityEvent event, ResourceRegistry registry) {
        try {
            int currentMultiplier = registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .getInt(LevelProperty.LevelPointsMultiplier.getName());
            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .putInt(LevelProperty.LevelPointsMultiplier.getName(), currentMultiplier + 1);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<IncreasePointsMultiplierEntityEvent> getExecutorType() {
        return IncreasePointsMultiplierEntityEvent.class;
    }
}
