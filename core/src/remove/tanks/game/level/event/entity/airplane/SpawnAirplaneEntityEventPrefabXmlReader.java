package remove.tanks.game.level.event.entity.airplane;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<SpawnAirplaneEntityEventPrefab> {
    @Override
    public SpawnAirplaneEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new SpawnAirplaneEntityEventPrefab();
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.SpawnAirplaneEntityEvent;
    }
}
