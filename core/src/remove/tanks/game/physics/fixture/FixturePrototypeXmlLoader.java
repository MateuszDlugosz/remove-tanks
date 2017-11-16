package remove.tanks.game.physics.fixture;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.filter.FilterPrototype;
import remove.tanks.game.physics.filter.FilterPrototypeXmlLoader;
import remove.tanks.game.physics.shape.ShapePrototype;
import remove.tanks.game.physics.shape.ShapePrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FixturePrototypeXmlLoader {
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

    private final ShapePrototypeXmlLoader shapePrototypeXmlLoader;
    private final FilterPrototypeXmlLoader filterPrototypeXmlLoader;

    public FixturePrototypeXmlLoader(
            ShapePrototypeXmlLoader shapePrototypeXmlLoader,
            FilterPrototypeXmlLoader filterPrototypeXmlLoader
    ) {
        this.shapePrototypeXmlLoader = shapePrototypeXmlLoader;
        this.filterPrototypeXmlLoader = filterPrototypeXmlLoader;
    }

    public List<FixturePrototype> loadFixturePrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(FIXTURE_ELEMENT).toArray())
                .map(this::loadFixturePrototype)
                .collect(Collectors.toList());
    }

    public FixturePrototype loadFixturePrototype(XmlReader.Element element) {
        try {
            return new FixturePrototype(
                    loadFilterPrototype(element),
                    loadShapePrototype(element),
                    loadRestitution(element),
                    loadDensity(element),
                    loadFriction(element),
                    loadIsSensor(element)
            );
        } catch (Exception e) {
            throw new FixturePrototypeXmlLoadException(element, e);
        }
    }

    private FilterPrototype loadFilterPrototype(XmlReader.Element element) {
        return filterPrototypeXmlLoader.loadFilterPrototype(
                element.getChildByName(FilterPrototypeXmlLoader.FILTER_ELEMENT)
        );
    }

    private ShapePrototype loadShapePrototype(XmlReader.Element element) {
        return shapePrototypeXmlLoader.loadShapePrototype(
                element.getChildByName(ShapePrototypeXmlLoader.SHAPE_ELEMENT)
        );
    }

    private float loadRestitution(XmlReader.Element element) {
        if (element.getChildByName(RESTITUTION_ELEMENT) == null) {
            return RESTITUTION_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(RESTITUTION_ELEMENT).getText().trim());
    }

    private float loadDensity(XmlReader.Element element) {
        if (element.getChildByName(DENSITY_ELEMENT) == null) {
            return DENSITY_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(DENSITY_ELEMENT).getText().trim());
    }

    private float loadFriction(XmlReader.Element element) {
        if (element.getChildByName(FRICTION_ELEMENT) == null) {
            return FRICTION_DEFAULT_VALUE;
        }
        return Float.valueOf(element.getChildByName(FRICTION_ELEMENT).getText().trim());
    }

    private boolean loadIsSensor(XmlReader.Element element) {
        if (element.getChildByName(IS_SENSOR_ELEMENT) == null) {
            return IS_SENSOR_DEFAULT_VALUE;
        }
        return Boolean.valueOf(element.getChildByName(IS_SENSOR_ELEMENT).getText().trim());
    }
}
