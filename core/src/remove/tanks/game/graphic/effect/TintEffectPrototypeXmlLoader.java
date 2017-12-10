package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectPrototypeXmlLoader
        implements RegistrableEffectPrototypeXmlLoader<TintEffectPrototype>
{
    private final ColorPrototypeXmlLoader colorPrototypeXmlLoader;

    public TintEffectPrototypeXmlLoader(ColorPrototypeXmlLoader colorPrototypeXmlLoader) {
        this.colorPrototypeXmlLoader = colorPrototypeXmlLoader;
    }

    @Override
    public TintEffectPrototype loadEffectPrototype(XmlReader.Element element) {
        try {
            return new TintEffectPrototype(loadColorPrototype(element));
        } catch (Exception e) {
            throw new EffectPrototypeXmlLoadException(e);
        }
    }

    private ColorPrototype loadColorPrototype(XmlReader.Element element) {
        return colorPrototypeXmlLoader.loadColorPrototype(
                element.getChildByName(ColorPrototypeXmlLoader.COLOR_ELEMENT)
        );
    }

    @Override
    public EffectType getLoaderType() {
        return EffectType.TintEffect;
    }
}
