package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TimeEndDefeatSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<TimeEndDefeatSystemPrefab> {
    @Override
    public TimeEndDefeatSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new TimeEndDefeatSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.TimeEndDefeatSystem;
    }
}
