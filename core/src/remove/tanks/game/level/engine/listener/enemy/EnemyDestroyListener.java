package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.listener.AbstractEntityListener;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.utility.number.counter.Counter;
import remove.tanks.game.utility.properties.Properties;

import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListener extends AbstractEntityListener {
    private final Properties properties;
    private final EventBus eventBus;
    private final Counter counter;
    private final Map<Integer, List<Event>> eventThresholds;

    public EnemyDestroyListener(
            int priority,
            Engine engine,
            Properties properties,
            EventBus eventBus,
            Counter counter,
            Map<Integer, List<Event>> eventThresholds
    ) {
        super(priority, EntityFamily.EnemyFamily.getFamily(), engine);
        this.properties = properties;
        this.eventBus = eventBus;
        this.counter = counter;
        this.eventThresholds = eventThresholds;
    }

    @Override
    public void entityAdded(Entity entity) { }

    @Override
    public void entityRemoved(Entity entity) {
        counter.update();

        properties.putInt(LevelProperty.LevelEnemiesLeft.getName(),
                properties.getInt(LevelProperty.LevelEnemiesLeft.getName()) -1);
        properties.putInt(LevelProperty.LevelEnemiesDestroyed.getName(),
                properties.getInt(LevelProperty.LevelEnemiesDestroyed.getName()) + 1);

        if (eventThresholds.containsKey(counter.getValue())) {
            eventBus.post(eventThresholds.get(counter.getValue()));
            eventThresholds.remove(counter.getValue());
        }
    }
}
