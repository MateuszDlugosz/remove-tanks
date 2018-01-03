package remove.tanks.game.level.engine.listener.invoker;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.counter.Counter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EnemyCountEventInvokerListenerFactory
        implements RegistrableEntityListenerFactory<EnemyCountEventInvokerListener, EnemyCountEventInvokerListenerPrototype>
{
    private final EventFactory eventFactory;

    public EnemyCountEventInvokerListenerFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    @Override
    public EnemyCountEventInvokerListener createEntityListener(EnemyCountEventInvokerListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        try {
            return new EnemyCountEventInvokerListener(
                    prototype.getPriority(),
                    registry.getResource(LevelResource.Engine.toString(), Engine.class),
                    registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    createEvents(prototype.getEventPrototypes()),
                    createCounter()
            );
        } catch (Exception e) {
            throw new EntityListenerCreateException(prototype, e);
        }
    }

    private Map<Integer, List<Event>> createEvents(Map<Integer, List<EventPrototype>> eventPrototypes) {
        return eventPrototypes.keySet().stream()
                .collect(Collectors.toMap(
                        l -> l,
                        l -> eventFactory.createEvents(eventPrototypes.get(l))
                ));
    }

    private Counter createCounter() {
        return new Counter(-1);
    }

    @Override
    public Class<EnemyCountEventInvokerListenerPrototype> getFactoryType() {
        return EnemyCountEventInvokerListenerPrototype.class;
    }
}
