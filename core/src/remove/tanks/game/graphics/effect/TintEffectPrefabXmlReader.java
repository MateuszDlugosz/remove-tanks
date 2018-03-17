package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class TintEffectPrefabXmlReader implements SubEffectPrefabXmlReader<TintEffectPrefab> {
    private final ColorPrefabXmlReader colorPrefabXmlReader;

    public TintEffectPrefabXmlReader(ColorPrefabXmlReader colorPrefabXmlReader) {
        this.colorPrefabXmlReader = colorPrefabXmlReader;
    }

    @Override
    public TintEffectPrefab readEffectPrefab(XmlReader.Element element) {
        try {
            return new TintEffectPrefab(readColorPrefab(element));
        } catch (Exception e) {
            throw new EffectPrefabXmlReadException(element, e);
        }
    }

    private ColorPrefab readColorPrefab(XmlReader.Element element) {
        return colorPrefabXmlReader.readColorPrefab(
                element.getChildByName(ColorPrefabXmlReader.COLOR_ELEMENT)
        );
    }

    @Override
    public EffectType getReaderType() {
        return EffectType.TintEffect;
    }
}
