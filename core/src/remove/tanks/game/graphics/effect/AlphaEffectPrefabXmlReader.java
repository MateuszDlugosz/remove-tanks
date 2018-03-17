package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AlphaEffectPrefabXmlReader implements SubEffectPrefabXmlReader<AlphaEffectPrefab> {
    private static final String ALPHA_VALUE_ELEMENT = "alphaValue";

    @Override
    public AlphaEffectPrefab readEffectPrefab(XmlReader.Element element) {
        try {
            return new AlphaEffectPrefab(readAlphaValue(element));
        } catch (Exception e) {
            throw new EffectPrefabXmlReadException(element, e);
        }
    }

    private float readAlphaValue(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(ALPHA_VALUE_ELEMENT).getText());
    }

    @Override
    public EffectType getReaderType() {
        return EffectType.AlphaEffect;
    }
}
