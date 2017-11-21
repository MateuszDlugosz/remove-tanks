package remove.tanks.game.level.engine.system.defeat;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelStatus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.property.ModifyPropertyEvent;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatSystem extends EntitySystem {
    private final Properties properties;
    private final EventBus eventBus;
    private final Timer timer;

    public OperationDefeatSystem(
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
        if (getEngine().getEntitiesFor(EntityFamily.PlayerControlledFamily.getFamily()).size() < 1) {
            if (properties.getInt(LevelProperty.LevelLifes.getName()) == 0) {
                if (timer.isComplete()) {
                    eventBus.post(new ModifyPropertyEvent(
                            LevelProperty.LevelStatus,
                            LevelStatus.Defeat.getName()
                    ));
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
