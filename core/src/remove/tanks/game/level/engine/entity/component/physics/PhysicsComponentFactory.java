package remove.tanks.game.level.engine.entity.component.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrefab;
import remove.tanks.game.physics.fixture.hitbox.HitBox;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefab;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrefab;
import remove.tanks.game.physics.light.LightHandler;
import remove.tanks.game.physics.light.LightHandlerFactory;
import remove.tanks.game.physics.light.LightHandlerPrefab;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentFactory implements SubComponentFactory<PhysicsComponent, PhysicsComponentPrefab> {
    private final BodyFactory bodyFactory;
    private final HitBoxFactory hitBoxFactory;
    private final SensorFactory sensorFactory;
    private final LightHandlerFactory lightHandlerFactory;

    public PhysicsComponentFactory(
            BodyFactory bodyFactory,
            HitBoxFactory hitBoxFactory,
            SensorFactory sensorFactory,
            LightHandlerFactory lightHandlerFactory
    ) {
        this.bodyFactory = bodyFactory;
        this.hitBoxFactory = hitBoxFactory;
        this.sensorFactory = sensorFactory;
        this.lightHandlerFactory = lightHandlerFactory;
    }

    @Override
    public PhysicsComponent createComponent(PhysicsComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            World world = registry.getResource(ResourceType.WorldResource, World.class);
            WorldLight worldLight = registry.getResource(ResourceType.WorldLightResource, WorldLight.class);
            Scale worldScale = registry.getResource(ResourceType.WorldScaleResource, Scale.class);

            Body body = createBody(prefab.getBodyPrefab(), world);
            body.setUserData(entity);

            return new PhysicsComponent(
                    body,
                    createHitBoxIdMap(prefab.getHitBoxPrefabs(), body, entity, worldScale),
                    createSensorIdMap(prefab.getSensorPrefabs(), body, worldScale),
                    createLightHandlerIdMap(prefab.getLightHandlerPrefabs(), worldLight, body, worldScale)
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Body createBody(BodyPrefab prefab, World world) {
        return bodyFactory.createBody(prefab, world);
    }

    private Map<String, HitBox> createHitBoxIdMap(List<HitBoxPrefab> prefabs, Body body, Entity entity, Scale worldScale) {
        return prefabs.stream()
                .collect(Collectors.toMap(
                        HitBoxPrefab::getId,
                        p -> {
                            HitBox hitBox = hitBoxFactory.createHitBox(p, body, worldScale);
                            hitBox.getFixture().setUserData(entity);
                            return hitBox;
                        }
                ));
    }

    private Map<String, Sensor> createSensorIdMap(List<SensorPrefab> prefabs, Body body, Scale worldScale) {
        return prefabs.stream()
                .collect(Collectors.toMap(
                        SensorPrefab::getId,
                        p -> {
                            Sensor sensor = sensorFactory.createSensor(p, body, worldScale);
                            sensor.getFixture().setUserData(sensor);
                            return sensor;
                        }
                ));
    }

    private Map<String, LightHandler> createLightHandlerIdMap(List<LightHandlerPrefab> prefabs, WorldLight worldLight, Body body, Scale worldScale) {
        return prefabs.stream()
                .collect(Collectors.toMap(
                        LightHandlerPrefab::getId,
                        p -> lightHandlerFactory.createLightHandler(p, body, worldLight, worldScale)
                ));
    }

    @Override
    public Class<PhysicsComponentPrefab> getFactoryType() {
        return PhysicsComponentPrefab.class;
    }
}
