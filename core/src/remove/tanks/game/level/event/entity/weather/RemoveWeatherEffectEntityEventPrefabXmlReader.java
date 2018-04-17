package remove.tanks.game.level.event.entity.weather;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<RemoveWeatherEffectEntityEventPrefab> {
    private static final String ID_ELEMENT = "id";

    @Override
    public RemoveWeatherEffectEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new RemoveWeatherEffectEntityEventPrefab(readId(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.RemoveWeatherEffectEntityEvent;
    }
}
