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
public final class ResetPointsMultiplierEntityEventExecutor implements SubEventExecutor<ResetPointsMultiplierEntityEvent> {
    @Override
    public void executeEvent(ResetPointsMultiplierEntityEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                    .putInt(LevelProperty.LevelPointsMultiplier.getName(), 1);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ResetPointsMultiplierEntityEvent> getExecutorType() {
        return ResetPointsMultiplierEntityEvent.class;
    }
}
