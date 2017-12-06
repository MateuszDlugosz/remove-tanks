package remove.tanks.game.level.engine.system.state.end;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystem extends EntitySystem {
    private final Timer timer;
    private final Properties properties;

    public LevelEndSystem(int priority, Timer timer, Properties properties) {
        super(priority);
        this.timer = timer;
        this.properties = properties;
    }

    @Override
    public void update(float deltaTime) {
        if (properties.getString(LevelProperty.LevelState.getName()).equals(LevelState.Victory.getName())
                || properties.getString(LevelProperty.LevelState.getName()).equals(LevelState.Defeat.getName()))
        {
            if (timer.isComplete()) {
                properties.putString(LevelProperty.LevelState.getName(), LevelState.End.getName());
                getEngine().removeSystem(this);
            } else {
                timer.update(deltaTime);
            }
        }
    }
}
