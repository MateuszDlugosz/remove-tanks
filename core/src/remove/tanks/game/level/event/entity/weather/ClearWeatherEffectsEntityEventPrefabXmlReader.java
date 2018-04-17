package remove.tanks.game.level.event.entity.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ClearWeatherEffectsEntityEventPrefab> {
    @Override
    public ClearWeatherEffectsEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new ClearWeatherEffectsEntityEventPrefab();
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ClearMessagesEntityEvent;
    }
}
