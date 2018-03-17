package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class FileSpritePrefabXmlReader implements SubSpritePrefabXmlReader<FileSpritePrefab> {
    private static final String FILENAME_ELEMENT = "filename";
    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    @Override
    public FileSpritePrefab readSpritePrefab(XmlReader.Element element) {
        try {
            return new FileSpritePrefab(
                    readFilename(element),
                    readFlipX(element),
                    readFlipY(element)
            );
        } catch (Exception e) {
            throw new SpritePrefabXmlReadException(element, e);
        }
    }

    private String readFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText();
    }

    private boolean readFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean readFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }

    @Override
    public SpriteType getReaderType() {
        return SpriteType.FileSprite;
    }
}
