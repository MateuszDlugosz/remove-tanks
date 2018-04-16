package remove.tanks.game.level.engine.system.state.reset;

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
public final class PlayerDestroyedResetSystem extends EntitySystem {
    private final EventBus eventBus;
    private final Timer timer;

    public PlayerDestroyedResetSystem(int priority, EventBus eventBus, Timer timer) {
        super(priority);
        this.eventBus = eventBus;
        this.timer = timer;
    }

    @Override
    public void update(float deltaTime) {
        if (getEngine().getEntitiesFor(EntityFamily.InputFamily.getFamily()).size() < 1) {
            if (timer.isCompleted()) {
                eventBus.post(new ChangeLevelStateEvent(LevelState.Reset));
                getEngine().removeSystem(this);
            } else {
                timer.update(deltaTime);
            }
        }
    }
}
