package remove.tanks.game.level.engine.system.damage;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.damage.DamageComponent;
import remove.tanks.game.level.engine.entity.component.health.HealthComponent;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightComponent;
import remove.tanks.game.level.engine.entity.component.layer.highlight.HighlightOnHitComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class DamageSystem extends IteratingSystem {
    private final float hitHighlightTime;

    public DamageSystem(int priority, float hitHighlightTime) {
        super(EntityFamily.DamagableFamily.getFamily(), priority);
        this.hitHighlightTime = hitHighlightTime;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        for (Sensor s : PhysicsComponent.MAPPER.get(entity).getSensors().values()) {
            if (s.isContacted()) {
                for (Object e : s.getContacts()) {
                    if (((Entity) e).getComponent(HealthComponent.class) != null) {
                        HealthComponent hc = HealthComponent.MAPPER.get((Entity) e);
                        ((Entity) e).add(
                                new HealthComponent(
                                        hc.getHealth() - DamageComponent.MAPPER.get(entity).getDamage(),
                                        hc.getMaxHealth()
                                )
                        );
                    }
                    if (((Entity) e).getComponent(HighlightOnHitComponent.class) != null) {
                        ((Entity) e).add(new HighlightComponent(new Timer(hitHighlightTime)));
                    }
                }
            }
        }
    }
}
