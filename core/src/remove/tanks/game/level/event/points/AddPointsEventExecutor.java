package remove.tanks.game.level.event.points;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventExecutor
        implements RegistrableEventExecutor<AddPointsEvent>
{
    @Override
    public void executeEvent(AddPointsEvent event, Level level) {
        Properties properties = level.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class);
        int points = event.getPoints() * properties.getInt(LevelProperty.LevelPointsMultiplier.getName());
        properties.putInt(
                LevelProperty.LevelPoints.getName(),
                properties.getInt(LevelProperty.LevelPoints.getName()) + points
        );
    }

    @Override
    public Class<AddPointsEvent> getExecutorType() {
        return AddPointsEvent.class;
    }
}
