package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorPrefabXmlReader implements SubColorPrefabXmlReader<RgbColorPrefab> {
    private static final String R_ELEMENT = "r";
    private static final String G_ELEMENT = "g";
    private static final String B_ELEMENT = "b";

    private static final float R_DEFAULT = 0f;
    private static final float G_DEFAULT = 0f;
    private static final float B_DEFAULT = 0f;

    @Override
    public final RgbColorPrefab readColorPrefab(XmlReader.Element element) {
        try {
            return new RgbColorPrefab(
                    readColorValue(element.getChildByName(R_ELEMENT), R_DEFAULT),
                    readColorValue(element.getChildByName(G_ELEMENT), G_DEFAULT),
                    readColorValue(element.getChildByName(B_ELEMENT), B_DEFAULT)
            );
        } catch (Exception e) {
            throw new ColorPrefabXmlReadException(element, e);
        }
    }

    private float readColorValue(XmlReader.Element element, float defaultValue) {
        if (element == null) {
            return defaultValue;
        }
        return Float.valueOf(element.getText().trim());
    }

    @Override
    public ColorType getReaderType() {
        return ColorType.RgbColor;
    }

}
