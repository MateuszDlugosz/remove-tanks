package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusComponentPrefabXmlReader implements SubComponentPrefabXmlReader<LeaveBonusComponentPrefab> {
    private static final String CHANCE_MODIFIER_ELEMENT = "chanceModifier";

    @Override
    public LeaveBonusComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new LeaveBonusComponentPrefab(readChanceModifier(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readChanceModifier(XmlReader.Element element) {
        return Optional.ofNullable(element.getChildByName(CHANCE_MODIFIER_ELEMENT))
                .map(e -> Float.valueOf(e.getText().trim()))
                .orElse(0f);
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.LeaveBonusComponent;
    }
}
