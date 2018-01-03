package remove.tanks.game.level.engine.listener.invoker;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.utility.counter.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EnemyCountEventInvokerListener extends ExtendedEntityListener {
    private final EventBus eventBus;
    private final Map<Integer, List<Event>> events;
    private final Counter counter;

    public EnemyCountEventInvokerListener(
            int priority,
            Engine engine,
            EventBus eventBus,
            Map<Integer, List<Event>> events,
            Counter counter
    ) {
        super(priority, EntityFamily.EnemiesFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.events = events;
        this.counter = counter;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        counter.update();
        List<Integer> keysToRemove = new ArrayList<>();
        events.forEach((k, v) -> {
            if (k >= counter.getValue()) {
                v.forEach(eventBus::post);
                keysToRemove.add(k);
            }
        });
        keysToRemove.forEach(events::remove);
        keysToRemove.clear();
    }
}
