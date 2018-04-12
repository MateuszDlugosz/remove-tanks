package remove.tanks.game.physics.fixture;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.filter.FilterPrefab;
import remove.tanks.game.physics.filter.FilterPrefabXmlReader;
import remove.tanks.game.physics.shape.ShapePrefab;
import remove.tanks.game.physics.shape.ShapePrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FixturePrefabXmlReader {
    public static final String FIXTURES_ELEMENT = "fixtures";
    public static final String FIXTURE_ELEMENT = "fixture";

    private static final String FRICTION_ELEMENT = "friction";
    private static final String DENSITY_ELEMENT = "density";
    private static final String RESTITUTION_ELEMENT = "restitution";
    private static final String IS_SENSOR_ELEMENT = "isSensor";

    private static final float FRICTION_DEFAULT_VALUE = 0f;
    private static final float DENSITY_DEFAULT_VALUE = 0f;
    private static final float RESTITUTION_DEFAULT_VALUE = 0f;
    private static final boolean IS_SENSOR_DEFAULT_VALUE = false;

    private final ShapePrefabXmlReader shapePrefabXmlReader;
    private final FilterPrefabXmlReader filterPrefabXmlReader;

    public FixturePrefabXmlReader(
            ShapePrefabXmlReader shapePrefabXmlReader,
            FilterPrefabXmlReader filterPrefabXmlReader
    ) {
        this.shapePrefabXmlReader = shapePrefabXmlReader;
        this.filterPrefabXmlReader = filterPrefabXmlReader;
    }

    public FixturePrefab readFixturePrefabAsHitBox(XmlReader.Element element) {
        try {
            return new FixturePrefab(
                    readFilterPrefab(element),
                    readShapePrefab(element),
                    readRestitution(element),
                    readDensity(element),
                    readFriction(element),
                    false
            );
        } catch (Exception e) {
            throw new FixturePrefabXmlReadException(element, e);
        }
    }

    public FixturePrefab readFixturePrefabAsSensor(XmlReader.Element element) {
        try {
            return new FixturePrefab(
                    readFilterPrefab(element),
                    readShapePrefab(element),
                    readRestitution(element),
                    readDensity(element),
                    readFriction(element),
                    false
            );
        } catch (Exception e) {
            throw new FixturePrefabXmlReadException(element, e);
        }
    }

    private FilterPrefab readFilterPrefab(XmlReader.Element element) {
        return filterPrefabXmlReader.readFilterPrefab(
                element.getChildByName(FilterPrefabXmlReader.FILTER_ELEMENT)
        );
    }

    private ShapePrefab readShapePrefab(XmlReader.Element element) {
        return shapePrefabXmlReader.readShapePrefab(
                element.getChildByName(ShapePrefabXmlReader.SHAPE_ELEMENT)
        );
    }

    private float readRestitution(XmlReader.Element element) {
        if (element.getChildByName(RESTITUTION_ELEMENT) == null) {
            return RESTITUTION_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(RESTITUTION_ELEMENT).getText().trim());
    }

    private float readDensity(XmlReader.Element element) {
        if (element.getChildByName(DENSITY_ELEMENT) == null) {
            return DENSITY_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(DENSITY_ELEMENT).getText().trim());
    }

    private float readFriction(XmlReader.Element element) {
        if (element.getChildByName(FRICTION_ELEMENT) == null) {
            return FRICTION_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(FRICTION_ELEMENT).getText().trim());
    }
}
