package remove.tanks.game.level.engine.system.input;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class InputSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<InputSystemPrefab> {
    @Override
    public InputSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new InputSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.InputSystem;
    }
}
