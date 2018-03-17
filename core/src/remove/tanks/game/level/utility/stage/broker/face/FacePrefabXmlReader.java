package remove.tanks.game.level.utility.stage.broker.face;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FacePrefabXmlReader {
    public static final String FACE_ELEMENT = "face";
    public static final String FACES_ELEMENT = "faces";

    private static final String ID_ATTRIBUTE = "id";

    private final SpritePrefabXmlReader spritePrefabXmlReader;

    public FacePrefabXmlReader(SpritePrefabXmlReader spritePrefabXmlReader) {
        this.spritePrefabXmlReader = spritePrefabXmlReader;
    }

    public List<FacePrefab> readFacePrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(FACE_ELEMENT).toArray())
                .map(this::readFacePrefab)
                .collect(Collectors.toList());
    }

    public FacePrefab readFacePrefab(XmlReader.Element element) {
        try {
            return new FacePrefab(
                    readId(element),
                    readSpritePrefab(element)
            );
        } catch (Exception e) {
            throw new FacePrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private SpritePrefab readSpritePrefab(XmlReader.Element element) {
        return spritePrefabXmlReader.readSpritePrefab(
                element.getChildByName(SpritePrefabXmlReader.SPRITE_ELEMENT)
        );
    }
}
