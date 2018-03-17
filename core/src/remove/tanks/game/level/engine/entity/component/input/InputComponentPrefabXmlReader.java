package remove.tanks.game.level.engine.entity.component.input;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class InputComponentPrefabXmlReader implements SubComponentPrefabXmlReader<InputComponentPrefab> {
    private static final String SHOOT_DELAY_ELEMENT = "shootDelay";

    @Override
    public InputComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new InputComponentPrefab(readShootDelay(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readShootDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(SHOOT_DELAY_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.InputComponent;
    }
}
