package remove.tanks.game.graphic.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class HexColorPrototypeXmlLoader implements RegistrableColorPrototypeXmlLoader<HexColorPrototype> {
    private static final String HEX_VALUE_ELEMENT = "hexValue";

    @Override
    public HexColorPrototype loadColorPrototype(XmlReader.Element element) {
        try {
            return new HexColorPrototype(loadHexValue(element));
        } catch (Exception e) {
            throw new ColorPrototypeXmlLoadException(element, e);
        }
    }

    private String loadHexValue(XmlReader.Element element) {
        return element.getChildByName(HEX_VALUE_ELEMENT).getText().trim();
    }

    @Override
    public ColorType getLoaderType() {
        return ColorType.HexColor;
    }
}
