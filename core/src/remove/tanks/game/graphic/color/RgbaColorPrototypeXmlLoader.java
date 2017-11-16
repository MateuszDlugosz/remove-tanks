package remove.tanks.game.graphic.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RgbaColorPrototypeXmlLoader implements RegistrableColorPrototypeXmlLoader<RgbaColorPrototype> {
    private static final String R_ELEMENT = "r";
    private static final String G_ELEMENT = "g";
    private static final String B_ELEMENT = "b";
    private static final String A_ELEMENT = "a";

    @Override
    public RgbaColorPrototype loadColorPrototype(XmlReader.Element element) {
        try {
            return new RgbaColorPrototype(
                    loadColorValue(element.getChildByName(R_ELEMENT)),
                    loadColorValue(element.getChildByName(G_ELEMENT)),
                    loadColorValue(element.getChildByName(B_ELEMENT)),
                    loadColorValue(element.getChildByName(A_ELEMENT))
            );
        } catch (Exception e) {
            throw new ColorPrototypeXmlLoadException(element, e);
        }
    }

    private float loadColorValue(XmlReader.Element element) {
        return Float.valueOf(element.getText().trim());
    }

    @Override
    public ColorType getLoaderType() {
        return ColorType.RgbaColor;
    }
}
