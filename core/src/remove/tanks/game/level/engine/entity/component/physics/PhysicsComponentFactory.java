package remove.tanks.game.level.engine.entity.component.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.physics.body.BodyFactory;
import remove.tanks.game.physics.body.BodyPrototype;
import remove.tanks.game.physics.fixture.hitbox.HitBox;
import remove.tanks.game.physics.fixture.hitbox.HitBoxFactory;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototype;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.physics.fixture.sensor.SensorFactory;
import remove.tanks.game.physics.fixture.sensor.SensorPrototype;
import remove.tanks.game.physics.light.LightHandler;
import remove.tanks.game.physics.light.LightHandlerFactory;
import remove.tanks.game.physics.light.LightHandlerPrototype;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentFactory
        implements RegistrableComponentFactory<PhysicsComponent, PhysicsComponentPrototype>
{
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
    public PhysicsComponent createComponent(PhysicsComponentPrototype prototype, Level level, Entity entity) {
        World world = level.getResourceRegistry()
                .getResource(LevelResource.World.toString(), World.class);
        WorldLight worldLight = level.getResourceRegistry()
                .getResource(LevelResource.WorldLight.toString(), WorldLight.class);
        Scale worldScale = level.getResourceRegistry()
                .getResource(LevelResource.WorldScale.toString(), Scale.class);

        Body body = createBody(prototype.getBodyPrototype(), world);
        body.setUserData(entity);
        return new PhysicsComponent(
                body,
                createHitBoxIdMap(prototype.getHitBoxPrototypes(), body, entity, worldScale),
                createSensorIdMap(prototype.getSensorPrototypes(), body, worldScale),
                createLightHandlerIdMap(prototype.getLightHandlerPrototypes(), worldLight, body, worldScale)
        );
    }

    private Body createBody(BodyPrototype prototype, World world) {
        return bodyFactory.createBody(prototype, world);
    }

    private Map<String, HitBox> createHitBoxIdMap(List<HitBoxPrototype> prototypes, Body body, Entity entity, Scale worldScale) {
        return prototypes.stream()
                .collect(Collectors.toMap(
                        HitBoxPrototype::getId,
                        p -> {
                            HitBox hitBox = hitBoxFactory.createHitBox(p, body, worldScale);
                            hitBox.getFixture().setUserData(entity);
                            return hitBox;
                        }
                ));
    }

    private Map<String, Sensor> createSensorIdMap(List<SensorPrototype> prototypes, Body body, Scale worldScale) {
        return prototypes.stream()
                .collect(Collectors.toMap(
                        SensorPrototype::getId,
                        p -> {
                            Sensor sensor = sensorFactory.createSensor(p, body, worldScale);
                            sensor.getFixture().setUserData(sensor);
                            return sensor;
                        }
                ));
    }

    private Map<String, LightHandler> createLightHandlerIdMap(List<LightHandlerPrototype> prototypes, WorldLight worldLight, Body body, Scale worldScale) {
        return prototypes.stream()
                .collect(Collectors.toMap(
                        LightHandlerPrototype::getId,
                        p -> lightHandlerFactory.createLightHandler(p, body, worldLight, worldScale)
                ));
    }

    @Override
    public Class<PhysicsComponentPrototype> getFactoryType() {
        return PhysicsComponentPrototype.class;
    }
}
