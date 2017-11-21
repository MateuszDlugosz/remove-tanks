package remove.tanks.game.level.engine.system.shoot;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AmmoComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AutoShootComponent;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystem extends IteratingSystem {
    private final EntityPrototypeRepository entityPrototypeRepository;
    private final EventBus eventBus;

    public AutoShootSystem(EventBus eventBus, EntityPrototypeRepository entityPrototypeRepository, int priority) {
        super(EntityFamily.AutoShootFamily.getFamily(), priority);
        this.eventBus = eventBus;
        this.entityPrototypeRepository = entityPrototypeRepository;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AmmoComponent.MAPPER.get(entity)
                .getPrototypeCodeForDirection(DirectionComponent.MAPPER.get(entity).getDirection())
                .ifPresent(c -> eventBus.post(new SpawnEntityEvent(
                        entityPrototypeRepository.getPrototype(c),
                        PhysicsComponent.MAPPER.get(entity).getPosition()
                )));
        entity.remove(AutoShootComponent.class);
    }
}
