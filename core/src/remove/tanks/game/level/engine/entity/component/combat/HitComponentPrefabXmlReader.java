package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.graphics.effect.EffectPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class HitComponentPrefabXmlReader implements SubComponentPrefabXmlReader<HitComponentPrefab> {
    private static final String HIT_TIME_ELEMENT = "hitTime";

    private final EffectPrefabXmlReader effectPrefabXmlReader;

    public HitComponentPrefabXmlReader(EffectPrefabXmlReader effectPrefabXmlReader) {
        this.effectPrefabXmlReader = effectPrefabXmlReader;
    }

    @Override
    public HitComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new HitComponentPrefab(
                    readEffectPrefab(element),
                    readHitTime(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private EffectPrefab readEffectPrefab(XmlReader.Element element) {
        return effectPrefabXmlReader.readEffectPrefab(element.getChildByName(EffectPrefabXmlReader.EFFECT_ELEMENT));
    }

    private float readHitTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(HIT_TIME_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.HitComponent;
    }
}
