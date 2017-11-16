package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AtlasSpritePrototypeXmlLoader
        implements RegistrableSpritePrototypeXmlLoader<AtlasSpritePrototype>
{
    private static final String ATLAS_FILENAME_ELEMENT = "atlasFilename";
    private static final String REGION_NAME_ELEMENT = "regionName";
    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    @Override
    public AtlasSpritePrototype loadSpritePrototype(XmlReader.Element element) {
        try {
            return new AtlasSpritePrototype(
                    loadAtlasFilename(element),
                    loadRegionName(element),
                    loadFlipX(element),
                    loadFlipY(element)
            );
        } catch (Exception e) {
            throw new SpritePrototypeXmlLoadException(element, e);
        }
    }

    private String loadAtlasFilename(XmlReader.Element element) {
        return element.getChildByName(ATLAS_FILENAME_ELEMENT).getText();
    }

    private String loadRegionName(XmlReader.Element element) {
        return element.getChildByName(REGION_NAME_ELEMENT).getText();
    }

    private boolean loadFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean loadFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }

    @Override
    public SpriteType getLoaderType() {
        return SpriteType.AtlasSprite;
    }
}
