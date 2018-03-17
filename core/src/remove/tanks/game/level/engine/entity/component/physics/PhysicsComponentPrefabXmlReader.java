package remove.tanks.game.level.engine.entity.component.physics;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.physics.body.BodyPrefab;
import remove.tanks.game.physics.body.BodyPrefabXmlReader;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefab;
import remove.tanks.game.physics.fixture.hitbox.HitBoxPrefabXmlReader;
import remove.tanks.game.physics.fixture.sensor.SensorPrefab;
import remove.tanks.game.physics.fixture.sensor.SensorPrefabXmlReader;
import remove.tanks.game.physics.light.LightHandlerPrefab;
import remove.tanks.game.physics.light.LightHandlerPrefabXmlReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PhysicsComponentPrefabXmlReader implements SubComponentPrefabXmlReader<PhysicsComponentPrefab> {
    private final BodyPrefabXmlReader bodyPrefabXmlReader;
    private final HitBoxPrefabXmlReader hitBoxPrefabXmlReader;
    private final SensorPrefabXmlReader sensorPrefabXmlReader;
    private final LightHandlerPrefabXmlReader lightHandlerPrefabXmlReader;

    public PhysicsComponentPrefabXmlReader(
            BodyPrefabXmlReader bodyPrefabXmlReader,
            HitBoxPrefabXmlReader hitBoxPrefabXmlReader,
            SensorPrefabXmlReader sensorPrefabXmlReader,
            LightHandlerPrefabXmlReader lightHandlerPrefabXmlReader
    ) {
        this.bodyPrefabXmlReader = bodyPrefabXmlReader;
        this.hitBoxPrefabXmlReader = hitBoxPrefabXmlReader;
        this.sensorPrefabXmlReader = sensorPrefabXmlReader;
        this.lightHandlerPrefabXmlReader = lightHandlerPrefabXmlReader;
    }

    @Override
    public PhysicsComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new PhysicsComponentPrefab(
                    readBody(element),
                    readHitBoxPrefabs(element),
                    readSensorPrefabs(element),
                    readLightHandlerPrefabs(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private BodyPrefab readBody(XmlReader.Element element) {
        return bodyPrefabXmlReader.readBodyPrefab(
                element.getChildByName(BodyPrefabXmlReader.BODY_ELEMENT)
        );
    }

    private List<HitBoxPrefab> readHitBoxPrefabs(XmlReader.Element element) {
        if (element.getChildByName(HitBoxPrefabXmlReader.HIT_BOXES_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return hitBoxPrefabXmlReader.readHitBoxPrefabs(
                element.getChildByName(HitBoxPrefabXmlReader.HIT_BOXES_ELEMENT)
        );
    }

    private List<SensorPrefab> readSensorPrefabs(XmlReader.Element element) {
        if (element.getChildByName(SensorPrefabXmlReader.SENSORS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return sensorPrefabXmlReader.readSensorPrefabs(
                element.getChildByName(SensorPrefabXmlReader.SENSORS_ELEMENT)
        );
    }

    private List<LightHandlerPrefab> readLightHandlerPrefabs(XmlReader.Element element) {
        if (element.getChildByName(LightHandlerPrefabXmlReader.LIGHT_HANDLERS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return lightHandlerPrefabXmlReader.readLightHandlerPrefabs(
                element.getChildByName(LightHandlerPrefabXmlReader.LIGHT_HANDLERS_ELEMENT)
        );
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.PhysicsComponent;
    }
}
