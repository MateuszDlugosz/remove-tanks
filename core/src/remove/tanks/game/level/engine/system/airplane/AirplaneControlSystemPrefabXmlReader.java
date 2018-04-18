package remove.tanks.game.level.engine.system.airplane;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneControlSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<AirplaneControlSystemPrefab> {
    @Override
    public AirplaneControlSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new AirplaneControlSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.AirplaneControlSystem;
    }
}
