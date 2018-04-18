package remove.tanks.game.level.engine.system.cloud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CloudControlSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<CloudControlSystemPrefab> {
    @Override
    public CloudControlSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new CloudControlSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.CloudControlSystem;
    }
}
