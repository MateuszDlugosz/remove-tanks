package remove.tanks.game.level.engine.system.hud.stages.broker.face;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.sprite.SpritePrototype;
import remove.tanks.game.graphic.sprite.SpritePrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FacePrototypeXmlLoader {
    public static final String FACE_ELEMENT = "face";
    public static final String FACES_ELEMENT = "faces";

    private static final String ID_ATTRIBUTE = "id";

    private final SpritePrototypeXmlLoader spritePrototypeXmlLoader;

    public FacePrototypeXmlLoader(SpritePrototypeXmlLoader spritePrototypeXmlLoader) {
        this.spritePrototypeXmlLoader = spritePrototypeXmlLoader;
    }

    public List<FacePrototype> loadFacePrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(FACE_ELEMENT).toArray())
                .map(this::loadFacePrototype)
                .collect(Collectors.toList());
    }

    public FacePrototype loadFacePrototype(XmlReader.Element element) {
        try {
            return new FacePrototype(
                    loadId(element),
                    loadSpritePrototype(element)
            );
        } catch (Exception e) {
            throw new FacePrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private SpritePrototype loadSpritePrototype(XmlReader.Element element) {
        return spritePrototypeXmlLoader.loadSpritePrototype(
                element.getChildByName(SpritePrototypeXmlLoader.SPRITE_ELEMENT)
        );
    }
}
