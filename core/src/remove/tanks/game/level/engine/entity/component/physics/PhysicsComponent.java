package remove.tanks.game.level.engine.entity.component.physics;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.fixture.hitbox.HitBox;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.physics.light.LightHandler;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponent implements Component {
    public static final ComponentMapper<PhysicsComponent> MAPPER = ComponentMapper.getFor(PhysicsComponent.class);

    private final Body body;
    private final Map<String, HitBox> hitBoxes;
    private final Map<String, Sensor> sensors;
    private final Map<String, LightHandler> lightHandlers;

    public PhysicsComponent(
            Body body,
            Map<String, HitBox> hitBoxes,
            Map<String, Sensor> sensors,
            Map<String, LightHandler> lightHandlers
    ) {
        this.body = body;
        this.hitBoxes = hitBoxes;
        this.sensors = sensors;
        this.lightHandlers = lightHandlers;
    }

    public Body getBody() {
        return body;
    }

    public Position getPosition() {
        return new Position(body.getPosition().x, body.getPosition().y);
    }

    public Optional<HitBox> getHitBox(String id) {
        return Optional.ofNullable(hitBoxes.get(id));
    }

    public Optional<Sensor> getSensor(String id) {
        return Optional.ofNullable(sensors.get(id));
    }

    public Optional<LightHandler> getLightHandler(String id) {
        return Optional.ofNullable(lightHandlers.get(id));
    }

    public Map<String, HitBox> getHitBoxes() {
        return hitBoxes;
    }

    public Map<String, Sensor> getSensors() {
        return sensors;
    }

    public Map<String, LightHandler> getLightHandlers() {
        return lightHandlers;
    }
}
