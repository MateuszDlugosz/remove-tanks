package remove.tanks.game.level.engine.system.combat;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.AmmoComponent;
import remove.tanks.game.level.engine.entity.component.combat.AutoShootComponent;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.utility.create.CreateEntry;

import java.util.ArrayList;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystem extends IteratingSystem {
    private final EventBus eventBus;

    public AutoShootSystem(int priority, EventBus eventBus) {
        super(EntityFamily.AutoShootFamily.getFamily(), priority);
        this.eventBus = eventBus;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AmmoComponent.MAPPER.get(entity)
                .getPrefabCodeForDirection(DirectionComponent.MAPPER.get(entity).getDirection())
                .ifPresent(c -> eventBus.post(new CreateEvent(new ArrayList<CreateEntry>(Lists.newArrayList(new CreateEntry(
                        c, PhysicsComponent.MAPPER.get(entity).getPosition()
                ))))));
        entity.remove(AutoShootComponent.class);
    }
}
