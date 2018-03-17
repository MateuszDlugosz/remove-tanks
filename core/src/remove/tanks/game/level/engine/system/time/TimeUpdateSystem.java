package remove.tanks.game.level.engine.system.time;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeUpdateSystem extends EntitySystem {
    private final Properties properties;

    public TimeUpdateSystem(int priority, Properties properties) {
        super(priority);
        this.properties = properties;
    }

    @Override
    public void update(float deltaTime) {
        properties.putFloat(
                LevelProperty.LevelTimeLeft.getName(),
                properties.getFloat(LevelProperty.LevelTimeLeft.getName()) - deltaTime
        );

        if (properties.getFloat(LevelProperty.LevelTimeLeft.getName()) <= 0) {
            properties.putFloat(LevelProperty.LevelTimeLeft.getName(), 0);
        }
    }
}
