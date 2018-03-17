package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.SubEntityListenerFactory;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.number.counter.Counter;
import remove.tanks.game.utility.properties.Properties;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerFactory implements SubEntityListenerFactory<EnemyDestroyListener, EnemyDestroyListenerPrefab> {
    private final EventFactory eventFactory;

    public EnemyDestroyListenerFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    @Override
    public EnemyDestroyListener createEntityListener(EnemyDestroyListenerPrefab prefab, ResourceRegistry registry, Engine engine) {
        try {
            return new EnemyDestroyListener(
                    prefab.getPriority(),
                    engine,
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    createCounter(),
                    createEventThresholds(prefab.getEventThresholds(), registry)
            );
        } catch (Exception e) {
            throw new EntityListenerCreateException(prefab, e);
        }
    }

    private Counter createCounter() {
        return new Counter(-1);
    }

    private Map<Integer, List<Event>> createEventThresholds(Map<Integer, List<EventPrefab>> thresholds, ResourceRegistry registry) {
        return thresholds.keySet().stream()
                .collect(Collectors.toMap(
                        k -> k,
                        k -> eventFactory.createEvents(thresholds.get(k), registry)
                ));
    }

    @Override
    public Class<EnemyDestroyListenerPrefab> getFactoryType() {
        return EnemyDestroyListenerPrefab.class;
    }
}
