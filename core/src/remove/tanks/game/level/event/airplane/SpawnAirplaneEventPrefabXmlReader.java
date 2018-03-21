package remove.tanks.game.level.event.airplane;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEventPrefabXmlReader implements SubEventPrefabXmlReader<SpawnAirplaneEventPrefab> {
    @Override
    public SpawnAirplaneEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return SpawnAirplaneEventPrefab.INSTANCE;
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EventType getReaderType() {
        return EventType.SpawnAirplaneEvent;
    }
}
