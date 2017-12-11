package remove.tanks.game.physics.fixture.hitbox;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.fixture.FixturePrototype;
import remove.tanks.game.physics.fixture.FixturePrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxPrototypeXmlLoader {
    public static final String HIT_BOX_ELEMENT = "hitBox";
    public static final String HIT_BOXES_ELEMENT = "hitBoxes";

    private static final String ID_ATTRIBUTE = "id";

    private final FixturePrototypeXmlLoader fixturePrototypeXmlLoader;

    public HitBoxPrototypeXmlLoader(FixturePrototypeXmlLoader fixturePrototypeXmlLoader) {
        this.fixturePrototypeXmlLoader = fixturePrototypeXmlLoader;
    }

    public List<HitBoxPrototype> loadHitBoxPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(HIT_BOX_ELEMENT).toArray())
                .map(this::loadHitBoxPrototype)
                .collect(Collectors.toList());
    }

    public HitBoxPrototype loadHitBoxPrototype(XmlReader.Element element) {
        try {
            return new HitBoxPrototype(
                    loadId(element),
                    loadFixturePrototype(element)
            );
        } catch (Exception e) {
            throw new HitBoxPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private FixturePrototype loadFixturePrototype(XmlReader.Element element) {
        return fixturePrototypeXmlLoader.loadFixturePrototypeAsHitBox(
                element.getChildByName(FixturePrototypeXmlLoader.FIXTURE_ELEMENT)
        );
    }
}
