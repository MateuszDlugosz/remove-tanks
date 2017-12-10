package remove.tanks.game.level.engine.system.state.victory;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.system.respawn.PlayerRespawnSystem;
import remove.tanks.game.level.event.state.ChangeLevelStateEvent;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictorySystem extends EntitySystem {
    private final Properties properties;
    private final EventBus eventBus;
    private final Timer timer;

    public OperationVictorySystem(
            int priority,
            Properties properties,
            EventBus eventBus,
            Timer timer
    ) {
        super(priority);
        this.properties = properties;
        this.eventBus = eventBus;
        this.timer = timer;
    }

    @Override
    public void update(float deltaTime) {
        if (getEngine().getEntitiesFor(EntityFamily.PlayerControlledFamily.getFamily()).size() > 0) {
            if (properties.getInt(LevelProperty.LevelEnemies.getName()) == 0) {
                if (timer.isComplete()) {
                    eventBus.post(new ChangeLevelStateEvent(LevelState.Victory));
                    Optional.ofNullable(getEngine().getSystem(PlayerRespawnSystem.class))
                            .ifPresent(s -> getEngine().removeSystem(s));
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
