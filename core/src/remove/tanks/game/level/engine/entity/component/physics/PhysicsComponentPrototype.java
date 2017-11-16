package remove.tanks.game.level.engine.entity.component.physics;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.physics.body.BodyPrototype;
import remove.tanks.game.physics.fixture.FixturePrototype;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototype;
import remove.tanks.game.physics.fixture.sensor.SensorPrototype;
import remove.tanks.game.physics.light.LightHandlerPrototype;
import remove.tanks.game.physics.light.LightPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentPrototype implements ComponentPrototype {
    private final BodyPrototype bodyPrototype;
    private final List<HitBoxPrototype> hitBoxPrototypes;
    private final List<SensorPrototype> sensorPrototypes;
    private final List<LightHandlerPrototype> lightHandlerPrototypes;

    public PhysicsComponentPrototype(
            BodyPrototype bodyPrototype,
            List<HitBoxPrototype> hitBoxPrototypes,
            List<SensorPrototype> sensorPrototypes,
            List<LightHandlerPrototype> lightHandlerPrototypes
    ) {
        this.bodyPrototype = bodyPrototype;
        this.hitBoxPrototypes = hitBoxPrototypes;
        this.sensorPrototypes = sensorPrototypes;
        this.lightHandlerPrototypes = lightHandlerPrototypes;
    }

    public BodyPrototype getBodyPrototype() {
        return bodyPrototype;
    }

    public List<HitBoxPrototype> getHitBoxPrototypes() {
        return hitBoxPrototypes;
    }

    public List<SensorPrototype> getSensorPrototypes() {
        return sensorPrototypes;
    }

    public List<LightHandlerPrototype> getLightHandlerPrototypes() {
        return lightHandlerPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bodyPrototype", bodyPrototype)
                .add("hitBoxPrototypes", hitBoxPrototypes)
                .add("sensorPrototypes", sensorPrototypes)
                .add("lightHandlerPrototypes", lightHandlerPrototypes)
                .toString();
    }
}
