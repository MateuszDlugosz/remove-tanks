package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.state.ChangeLevelStateEvent;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class NoLifesDefeatSystem extends EntitySystem {
    private final Properties properties;
    private final EventBus eventBus;
    private Timer timer;

    public NoLifesDefeatSystem(int priority, Properties properties, EventBus eventBus, Timer timer) {
        super(priority);
        this.properties = properties;
        this.eventBus = eventBus;
        this.timer = timer;
    }

    @Override
    public void update(float deltaTime) {
        if (getEngine().getEntitiesFor(EntityFamily.InputFamily.getFamily()).size() < 1) {
            if (properties.getInt(LevelProperty.LevelLifes.getName()) == 0) {
                if (timer.isCompleted()) {
                    eventBus.post(new ChangeLevelStateEvent(LevelState.Defeat));
                    getEngine().removeSystem(this);
                } else {
                    timer.update(deltaTime);
                }
            } else {
                timer.reset();
            }
        } else {
            timer.reset();
        }
    }
}
