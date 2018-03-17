package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class HexColorPrefabXmlReader implements SubColorPrefabXmlReader<HexColorPrefab> {
    private static final String HEX_VALUE_ELEMENT = "hexValue";

    @Override
    public HexColorPrefab readColorPrefab(XmlReader.Element element) {
        try {
            return new HexColorPrefab(readHexValue(element));
        } catch (Exception e) {
            throw new ColorPrefabXmlReadException(element, e);
        }
    }

    private String readHexValue(XmlReader.Element element) {
        return element.getChildByName(HEX_VALUE_ELEMENT).getText().trim();
    }

    @Override
    public ColorType getReaderType() {
        return ColorType.HexColor;
    }
}

