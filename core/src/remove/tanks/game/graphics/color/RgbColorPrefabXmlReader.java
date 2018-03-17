package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorPrefabXmlReader implements SubColorPrefabXmlReader<RgbColorPrefab> {
    private static final String R_ELEMENT = "r";
    private static final String G_ELEMENT = "g";
    private static final String B_ELEMENT = "b";

    @Override
    public final RgbColorPrefab readColorPrefab(XmlReader.Element element) {
        try {
            return new RgbColorPrefab(
                    readColorValue(element.getChildByName(R_ELEMENT)),
                    readColorValue(element.getChildByName(G_ELEMENT)),
                    readColorValue(element.getChildByName(B_ELEMENT))
            );
        } catch (Exception e) {
            throw new ColorPrefabXmlReadException(element, e);
        }
    }

    private float readColorValue(XmlReader.Element element) {
        return Float.valueOf(element.getText().trim());
    }

    @Override
    public ColorType getReaderType() {
        return ColorType.RgbColor;
    }

}
