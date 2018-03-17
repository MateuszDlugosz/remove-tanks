package remove.tanks.game.level.engine.system.move;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedModifierComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.level.utility.state.State;
import remove.tanks.game.physics.fixture.sensor.Sensor;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystem extends IteratingSystem {
    public AutoMoveSystem(int priority) {
        super(EntityFamily.AutoMoveFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
        if (StateComponent.MAPPER.get(entity).getState() == State.Moving) {
            DirectionComponent dc = DirectionComponent.MAPPER.get(entity);
            SpeedComponent sc = SpeedComponent.MAPPER.get(entity);
            Optional<Sensor> sensor = pc.getSensor(dc.getDirection().toString());
            pc.getBody().setLinearVelocity(
                    sensor.map(s -> calculateVelocityWithSensor(sc.getSpeed(), dc.getDirection(), s, getSpeedModifier(entity)))
                            .orElseGet(() -> calculateVelocity(sc.getSpeed(), dc.getDirection(), getSpeedModifier(entity))));
        } else {
            pc.getBody().setLinearVelocity(Vector2.Zero);
        }
        entity.remove(SpeedModifierComponent.class);
    }

    private float getSpeedModifier(Entity entity) {
        float modifier = 1;
        if (entity.getComponent(SpeedModifierComponent.class) != null) {
            modifier = entity.getComponent(SpeedModifierComponent.class).getSpeedModifier();
        }
        return modifier;
    }

    private Vector2 calculateVelocityWithSensor(float speed, Direction direction, Sensor sensor, float modifier) {
        return (sensor.isContacted()) ? Vector2.Zero : calculateVelocity(speed, direction, modifier);
    }

    private Vector2 calculateVelocity(float speed, Direction direction, float modifier) {
        switch (direction) {
            case Left: return new Vector2(-speed * modifier, 0);
            case Right: return new Vector2(speed * modifier, 0);
            case Up: return new Vector2(0, speed * modifier);
            case Down: return new Vector2(0, -speed * modifier);
            default: return Vector2.Zero;
        }
    }
}
