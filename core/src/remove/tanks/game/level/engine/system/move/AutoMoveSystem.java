package remove.tanks.game.level.engine.system.move;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.speed.SpeedComponent;
import remove.tanks.game.level.engine.entity.component.state.StateComponent;
import remove.tanks.game.level.engine.utility.direction.Direction;
import remove.tanks.game.level.engine.utility.state.State;
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
                    sensor
                            .map(s -> calculateVelocityWithSensor(sc.getSpeed(), dc.getDirection(), s))
                            .orElseGet(() -> calculateVelocity(sc.getSpeed(), dc.getDirection()))
            );
        } else {
            pc.getBody().setLinearVelocity(Vector2.Zero);
        }
    }

    private Vector2 calculateVelocityWithSensor(float speed, Direction direction, Sensor sensor) {
        return (sensor.isContacted()) ? Vector2.Zero : calculateVelocity(speed, direction);

    }

    private Vector2 calculateVelocity(float speed, Direction direction) {
        switch (direction) {
            case Left: return new Vector2(-speed, 0);
            case Right: return new Vector2(speed, 0);
            case Up: return new Vector2(0, speed);
            case Down: return new Vector2(0, -speed);
            default: return Vector2.Zero;
        }
    }
}
