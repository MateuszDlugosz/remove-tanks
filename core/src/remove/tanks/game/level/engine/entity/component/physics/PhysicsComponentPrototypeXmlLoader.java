package remove.tanks.game.level.engine.entity.component.physics;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.physics.body.BodyPrototype;
import remove.tanks.game.physics.body.BodyPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototype;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrototypeXmlLoader;
import remove.tanks.game.physics.fixture.sensor.SensorPrototype;
import remove.tanks.game.physics.fixture.sensor.SensorPrototypeXmlLoader;
import remove.tanks.game.physics.light.LightHandlerPrototype;
import remove.tanks.game.physics.light.LightHandlerPrototypeXmlLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<PhysicsComponentPrototype>
{
    private final BodyPrototypeXmlLoader bodyPrototypeXmlLoader;
    private final HitBoxPrototypeXmlLoader hitBoxPrototypeXmlLoader;
    private final SensorPrototypeXmlLoader sensorPrototypeXmlLoader;
    private final LightHandlerPrototypeXmlLoader lightHandlerPrototypeXmlLoader;

    public PhysicsComponentPrototypeXmlLoader(
            BodyPrototypeXmlLoader bodyPrototypeXmlLoader,
            HitBoxPrototypeXmlLoader hitBoxPrototypeXmlLoader,
            SensorPrototypeXmlLoader sensorPrototypeXmlLoader,
            LightHandlerPrototypeXmlLoader lightHandlerPrototypeXmlLoader
    ) {
        this.bodyPrototypeXmlLoader = bodyPrototypeXmlLoader;
        this.hitBoxPrototypeXmlLoader = hitBoxPrototypeXmlLoader;
        this.sensorPrototypeXmlLoader = sensorPrototypeXmlLoader;
        this.lightHandlerPrototypeXmlLoader = lightHandlerPrototypeXmlLoader;
    }

    @Override
    public PhysicsComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new PhysicsComponentPrototype(
                    loadBody(element),
                    loadHitBoxPrototypes(element),
                    loadSensorPrototypes(element),
                    loadLightHandlerPrototypes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private BodyPrototype loadBody(XmlReader.Element element) {
        return bodyPrototypeXmlLoader.loadBodyPrototype(
                element.getChildByName(BodyPrototypeXmlLoader.BODY_ELEMENT)
        );
    }

    private List<HitBoxPrototype> loadHitBoxPrototypes(XmlReader.Element element) {
        if (element.getChildByName(HitBoxPrototypeXmlLoader.HIT_BOXES_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return hitBoxPrototypeXmlLoader.loadHitBoxPrototypes(
                element.getChildByName(HitBoxPrototypeXmlLoader.HIT_BOXES_ELEMENT)
        );
    }

    private List<SensorPrototype> loadSensorPrototypes(XmlReader.Element element) {
        if (element.getChildByName(SensorPrototypeXmlLoader.SENSORS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return sensorPrototypeXmlLoader.loadSensorPrototypes(
                element.getChildByName(SensorPrototypeXmlLoader.SENSORS_ELEMENT)
        );
    }

    private List<LightHandlerPrototype> loadLightHandlerPrototypes(XmlReader.Element element) {
        if (element.getChildByName(LightHandlerPrototypeXmlLoader.LIGHT_HANDLERS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return lightHandlerPrototypeXmlLoader.loadLightHandlerPrototypes(
                element.getChildByName(LightHandlerPrototypeXmlLoader.LIGHT_HANDLERS_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PhysicsComponent;
    }
}
