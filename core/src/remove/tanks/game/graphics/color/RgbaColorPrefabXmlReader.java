package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RgbaColorPrefabXmlReader implements SubColorPrefabXmlReader<RgbaColorPrefab> {
    private static final String R_ELEMENT = "r";
    private static final String G_ELEMENT = "g";
    private static final String B_ELEMENT = "b";
    private static final String A_ELEMENT = "a";

    @Override
    public RgbaColorPrefab readColorPrefab(XmlReader.Element element) {
        try {
            return new RgbaColorPrefab(
                    readColorValue(element.getChildByName(R_ELEMENT)),
                    readColorValue(element.getChildByName(G_ELEMENT)),
                    readColorValue(element.getChildByName(B_ELEMENT)),
                    readColorValue(element.getChildByName(A_ELEMENT))
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
        return ColorType.RgbaColor;
    }
}
