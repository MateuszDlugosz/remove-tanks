package remove.tanks.game.level.engine.system.state.end;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystem extends EntitySystem {
    private final Properties properties;
    private final Timer timer;

    public LevelEndSystem(int priority, Properties properties, Timer timer) {
        super(priority);
        this.properties = properties;
        this.timer = timer;
    }

    @Override
    public void update(float deltaTime) {
        if (properties.getString(LevelProperty.LevelState.getName()).equals(LevelState.Victory.getName())
                || properties.getString(LevelProperty.LevelState.getName()).equals(LevelState.Defeat.getName()))
        {
            if (timer.isCompleted()) {
                properties.putString(LevelProperty.LevelState.getName(), LevelState.End.getName());
                getEngine().removeSystem(this);
            } else {
                timer.update(deltaTime);
            }
        }
    }
}
