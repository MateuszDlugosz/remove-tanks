package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

public final class DestroyOnContactSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<DestroyOnContactSystemPrefab> {
    @Override
    public DestroyOnContactSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new DestroyOnContactSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.DestroyOnContactSystem;
    }
}
