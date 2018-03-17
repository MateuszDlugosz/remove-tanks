package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentPrefabXmlReader implements SubComponentPrefabXmlReader<DamageComponentPrefab> {
    private static final String DAMAGE_ELEMENT = "damage";

    @Override
    public DamageComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new DamageComponentPrefab(readDamage(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private int readDamage(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(DAMAGE_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DamageComponent;
    }
}
