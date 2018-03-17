package remove.tanks.game.level.engine.entity.component.physics;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.physics.body.BodyPrefab;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefab;
import remove.tanks.game.physics.fixture.sensor.SensorPrefab;
import remove.tanks.game.physics.light.LightHandlerPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentPrefab extends ComponentPrefab {
    private final BodyPrefab bodyPrefab;
    private final List<HitBoxPrefab> hitBoxPrefabs;
    private final List<SensorPrefab> sensorPrefabs;
    private final List<LightHandlerPrefab> lightHandlerPrefabs;

    public PhysicsComponentPrefab(
            BodyPrefab bodyPrefab,
            List<HitBoxPrefab> hitBoxPrefabs,
            List<SensorPrefab> sensorPrefabs,
            List<LightHandlerPrefab> lightHandlerPrefabs
    ) {
        this.bodyPrefab = bodyPrefab;
        this.hitBoxPrefabs = hitBoxPrefabs;
        this.sensorPrefabs = sensorPrefabs;
        this.lightHandlerPrefabs = lightHandlerPrefabs;
    }

    public BodyPrefab getBodyPrefab() {
        return bodyPrefab;
    }

    public List<HitBoxPrefab> getHitBoxPrefabs() {
        return hitBoxPrefabs;
    }

    public List<SensorPrefab> getSensorPrefabs() {
        return sensorPrefabs;
    }

    public List<LightHandlerPrefab> getLightHandlerPrefabs() {
        return lightHandlerPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bodyPrefab", bodyPrefab)
                .add("hitBoxPrefabs", hitBoxPrefabs)
                .add("sensorPrefabs", sensorPrefabs)
                .add("lightHandlerPrefabs", lightHandlerPrefabs)
                .toString();
    }
}
