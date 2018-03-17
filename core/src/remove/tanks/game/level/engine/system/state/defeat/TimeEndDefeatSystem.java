package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.state.ChangeLevelStateEvent;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeEndDefeatSystem extends EntitySystem {
    private final Properties properties;
    private final EventBus eventBus;

    public TimeEndDefeatSystem(int priority, Properties properties, EventBus eventBus) {
        super(priority);
        this.properties = properties;
        this.eventBus = eventBus;
    }

    @Override
    public void update(float deltaTime) {
        if (properties.getFloat(LevelProperty.LevelTimeLeft.getName()) <= 0.0) {
            eventBus.post(new ChangeLevelStateEvent(LevelState.Defeat));
            getEngine().removeSystem(this);
        }
    }
}
