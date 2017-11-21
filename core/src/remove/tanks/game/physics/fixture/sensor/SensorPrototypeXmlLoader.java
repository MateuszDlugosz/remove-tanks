package remove.tanks.game.physics.fixture.sensor;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.fixture.FixturePrototype;
import remove.tanks.game.physics.fixture.FixturePrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class SensorPrototypeXmlLoader {
    public static final String SENSOR_ELEMENT = "sensor";
    public static final String SENSORS_ELEMENT = "sensors";

    private static final String ID_ATTRIBUTE = "id";

    private final FixturePrototypeXmlLoader fixturePrototypeXmlLoader;

    public SensorPrototypeXmlLoader(FixturePrototypeXmlLoader fixturePrototypeXmlLoader) {
        this.fixturePrototypeXmlLoader = fixturePrototypeXmlLoader;
    }

    public List<SensorPrototype> loadSensorPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(SENSOR_ELEMENT).toArray())
                .map(this::loadSensorPrototype)
                .collect(Collectors.toList());
    }

    public SensorPrototype loadSensorPrototype(XmlReader.Element element) {
        try {
            return new SensorPrototype(
                    loadId(element),
                    loadFixturePrototype(element)
            );
        } catch (Exception e) {
            throw new SensorPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private FixturePrototype loadFixturePrototype(XmlReader.Element element) {
        return fixturePrototypeXmlLoader.loadFixturePrototype(
                element.getChildByName(FixturePrototypeXmlLoader.FIXTURE_ELEMENT)
        );
    }
}
