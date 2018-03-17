package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.sprite.SpritePrefab;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewPrefabXmlReader implements SubViewPrefabXmlReader<SpriteViewPrefab> {
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final SpritePrefabXmlReader spritePrefabXmlReader;

    public SpriteViewPrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            SpritePrefabXmlReader spritePrefabXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.spritePrefabXmlReader = spritePrefabXmlReader;
    }

    @Override
    public SpriteViewPrefab readViewPrefab(XmlReader.Element element) {
        try {
            return new SpriteViewPrefab(
                    readId(element),
                    readViewPositionPrefab(element),
                    readSpritePrefab(element)
            );
        } catch (Exception e) {
            throw new ViewPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrefab readViewPositionPrefab(XmlReader.Element element) {
        return element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null
                ? PositionPrefab.POSITION_PREFAB_ZERO
                : positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private SpritePrefab readSpritePrefab(XmlReader.Element element) {
        return spritePrefabXmlReader.readSpritePrefab(
                element.getChildByName(SpritePrefabXmlReader.SPRITE_ELEMENT)
        );
    }

    @Override
    public ViewType getReaderType() {
        return ViewType.SpriteView;
    }
}
