package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectPrototypeXmlLoader
        implements RegistrableEffectPrototypeXmlLoader<AlphaEffectPrototype>
{
    private static final String ALPHA_VALUE_ELEMENT = "alphaValue";

    @Override
    public AlphaEffectPrototype loadEffectPrototype(XmlReader.Element element) {
        try {
            return new AlphaEffectPrototype(loadAlphaValue(element));
        } catch (Exception e) {
            throw new EffectPrototypeXmlLoadException(element, e);
        }
    }

    private float loadAlphaValue(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(ALPHA_VALUE_ELEMENT).getText());
    }

    @Override
    public EffectType getLoaderType() {
        return EffectType.AlphaEffect;
    }
}
