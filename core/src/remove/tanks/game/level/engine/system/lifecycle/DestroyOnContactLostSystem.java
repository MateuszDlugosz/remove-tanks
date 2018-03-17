package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.entity.destroy.DestroyEntityEvent;
import remove.tanks.game.physics.fixture.sensor.Sensor;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactLostSystem extends IteratingSystem {
    private final EventBus eventBus;

    public DestroyOnContactLostSystem(int priority, EventBus eventBus) {
        super(EntityFamily.DestroyOnContactLostFamily.getFamily(), priority);
        this.eventBus = eventBus;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        boolean contacted = false;
        for (Sensor sensor : PhysicsComponent.MAPPER.get(entity).getSensors().values()) {
            if (sensor.isContacted()) {
                contacted = true;
            }
        }
        if (!contacted) {
            eventBus.post(new DestroyEntityEvent(entity));
        }
    }
}
