package remove.tanks.game.level.engine.system.combat;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.DamageComponent;
import remove.tanks.game.level.engine.entity.component.combat.HealthComponent;
import remove.tanks.game.level.engine.entity.component.combat.HitComponent;
import remove.tanks.game.level.engine.entity.component.combat.ProtectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class CombatSystem extends IteratingSystem {
    private final Effect hitEffect;
    private final float hitTime;

    public CombatSystem(int priority, Effect hitEffect, float hitTime) {
        super(EntityFamily.DamageFamily.getFamily(), priority);
        this.hitEffect = hitEffect;
        this.hitTime = hitTime;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent.MAPPER.get(entity).getSensors().values().forEach(s -> {
            if (s.isContacted()) {
                s.getContacts().forEach(o -> {
                    if (((Entity) o).getComponent(HealthComponent.class) != null) {
                        if (((Entity) o).getComponent(ProtectionComponent.class) == null) {
                            HealthComponent hc = HealthComponent.MAPPER.get((Entity) o);
                            ((Entity) o).add(new HealthComponent(
                                    hc.getMaxHealth(),
                                    hc.getHealth() - DamageComponent.MAPPER.get(entity).getDamage()
                            ));
                            ((Entity) o).add(new HitComponent(hitEffect, new Timer(hitTime)));
                        }
                    }
                });
            }
        });
    }
}
