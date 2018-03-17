package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactLostSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<DestroyOnContactLostSystemPrefab> {
    @Override
    public DestroyOnContactLostSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new DestroyOnContactLostSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.DestroyOnContactLostSystem;
    }
}
