package remove.tanks.game.physics.fixture.hitbox;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.physics.fixture.FixturePrefab;
import remove.tanks.game.physics.fixture.FixturePrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxPrefabXmlReader {
    public static final String HIT_BOX_ELEMENT = "hitBox";
    public static final String HIT_BOXES_ELEMENT = "hitBoxes";

    private static final String ID_ATTRIBUTE = "id";

    private final FixturePrefabXmlReader fixturePrefabXmlReader;

    public HitBoxPrefabXmlReader(FixturePrefabXmlReader fixturePrefabXmlReader) {
        this.fixturePrefabXmlReader = fixturePrefabXmlReader;
    }

    public List<HitBoxPrefab> readHitBoxPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(HIT_BOX_ELEMENT).toArray())
                .map(this::readHitBoxPrefab)
                .collect(Collectors.toList());
    }

    public HitBoxPrefab readHitBoxPrefab(XmlReader.Element element) {
        try {
            return new HitBoxPrefab(
                    readId(element),
                    readFixturePrefab(element)
            );
        } catch (Exception e) {
            throw new HitBoxPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private FixturePrefab readFixturePrefab(XmlReader.Element element) {
        return fixturePrefabXmlReader.readFixturePrefab(
                element.getChildByName(FixturePrefabXmlReader.FIXTURE_ELEMENT)
        );
    }
}
