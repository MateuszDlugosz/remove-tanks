package remove.tanks.game.level.engine.listener.spawn;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.SpawnOnDestroyComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class SpawnCycleListener extends ExtendedEntityListener {
    private final EntityPrototypeRepository entityPrototypeRepository;
    private final EventBus eventBus;

    public SpawnCycleListener(
            EventBus eventBus,
            EntityPrototypeRepository entityPrototypeRepository,
            Engine engine,
            int priority
    ) {
        super(priority, EntityFamily.LifecycleFamily.getFamily(), engine);
        this.eventBus = eventBus;
        this.entityPrototypeRepository = entityPrototypeRepository;
    }

    @Override
    public void entityAdded(Entity entity) {

    }

    @Override
    public void entityRemoved(Entity entity) {
        if (entity.getComponent(SpawnOnDestroyComponent.class) != null) {
            SpawnOnDestroyComponent sodc = SpawnOnDestroyComponent.MAPPER.get(entity);
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            sodc.getSpawnEntries().forEach(
                    e -> eventBus.post(new SpawnEntityEvent(
                            entityPrototypeRepository.getPrototype(e.getPrototypeCode()),
                            pc.getPosition().sum(e.getPosition())
                    ))
            );
        }
    }
}
