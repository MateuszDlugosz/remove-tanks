package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponentPrefabXmlReader implements SubComponentPrefabXmlReader<SpeedModifierComponentPrefab> {
    private static final String SPEED_MODIFIER_ELEMENT = "speedModifier";

    @Override
    public SpeedModifierComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new SpeedModifierComponentPrefab(
                    readSpeedModifier(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readSpeedModifier(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(SPEED_MODIFIER_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.SpeedModifierComponent;
    }
}
