package remove.tanks.game.level.engine.system.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TimeUpdateSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<TimeUpdateSystemPrefab> {
    @Override
    public TimeUpdateSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new TimeUpdateSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.TimeUpdateSystem;
    }
}
