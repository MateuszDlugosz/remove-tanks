package remove.tanks.game.physics.fixture.sensor;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.fixture.FixturePrefab;
import remove.tanks.game.physics.fixture.FixturePrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SensorPrefabXmlReader {
    public static final String SENSOR_ELEMENT = "sensor";
    public static final String SENSORS_ELEMENT = "sensors";

    private static final String ID_ATTRIBUTE = "id";

    private final FixturePrefabXmlReader fixturePrefabXmlReader;

    public SensorPrefabXmlReader(FixturePrefabXmlReader fixturePrefabXmlReader) {
        this.fixturePrefabXmlReader = fixturePrefabXmlReader;
    }

    public List<SensorPrefab> readSensorPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SENSOR_ELEMENT).toArray())
                .map(this::readSensorPrefab)
                .collect(Collectors.toList());
    }

    public SensorPrefab readSensorPrefab(XmlReader.Element element) {
        try {
            return new SensorPrefab(
                    readId(element),
                    readFixturePrefab(element)
            );
        } catch (Exception e) {
            throw new SensorPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private FixturePrefab readFixturePrefab(XmlReader.Element element) {
        return fixturePrefabXmlReader.readFixturePrefabAsSensor(
                element.getChildByName(FixturePrefabXmlReader.FIXTURE_ELEMENT)
        );
    }
}
