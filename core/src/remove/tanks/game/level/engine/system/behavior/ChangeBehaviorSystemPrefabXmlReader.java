package remove.tanks.game.level.engine.system.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<ChangeBehaviorSystemPrefab> {
    @Override
    public ChangeBehaviorSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new ChangeBehaviorSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.ChangeBehaviorSystem;
    }
}
