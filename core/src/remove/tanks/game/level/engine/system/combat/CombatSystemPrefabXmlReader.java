package remove.tanks.game.level.engine.system.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.effect.EffectPrefab;
import remove.tanks.game.graphics.effect.EffectPrefabXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CombatSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<CombatSystemPrefab> {
    private static final String HIT_EFFECT_ELEMENT = "hitEffect";
    private static final String HIT_TIME_ELEMENT = "hitTime";

    private final EffectPrefabXmlReader effectPrefabXmlReader;

    public CombatSystemPrefabXmlReader(EffectPrefabXmlReader effectPrefabXmlReader) {
        this.effectPrefabXmlReader = effectPrefabXmlReader;
    }

    @Override
    public CombatSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new CombatSystemPrefab(
                    priority,
                    readHitEffectPrefab(element),
                    readHitTime(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private EffectPrefab readHitEffectPrefab(XmlReader.Element element) {
        return effectPrefabXmlReader.readEffectPrefab(
                element.getChildByName(HIT_EFFECT_ELEMENT).getChildByName(EffectPrefabXmlReader.EFFECT_ELEMENT));
    }

    private float readHitTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(HIT_TIME_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.CombatSystem;
    }
}
