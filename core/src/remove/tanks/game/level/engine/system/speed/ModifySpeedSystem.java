package remove.tanks.game.level.engine.system.speed;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.speed.ModifySpeedComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedModifierComponent;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedSystem extends IteratingSystem {
    public ModifySpeedSystem(int priority) {
        super(EntityFamily.ModifySpeedFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent.MAPPER.get(entity).getSensors().values().forEach(s -> {
                if (s.isContacted()) {
                    s.getContacts().forEach(c -> ((Entity) c).add(new SpeedModifierComponent(
                            ModifySpeedComponent.MAPPER.get(entity).getValue()
                    )));
                }
        });
    }
}
