package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class DestroySystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<DestroySystemPrefab> {
    @Override
    public DestroySystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new DestroySystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.DestroySystem;
    }
}
