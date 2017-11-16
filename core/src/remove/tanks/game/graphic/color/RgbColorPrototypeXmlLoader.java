package remove.tanks.game.graphic.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RgbColorPrototypeXmlLoader implements RegistrableColorPrototypeXmlLoader<RgbColorPrototype> {
    private static final String R_ELEMENT = "r";
    private static final String G_ELEMENT = "g";
    private static final String B_ELEMENT = "b";

    @Override
    public RgbColorPrototype loadColorPrototype(XmlReader.Element element) {
        try {
            return new RgbColorPrototype(
                    loadColorValue(element.getChildByName(R_ELEMENT)),
                    loadColorValue(element.getChildByName(G_ELEMENT)),
                    loadColorValue(element.getChildByName(B_ELEMENT))
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
        return ColorType.RgbColor;
    }
}
