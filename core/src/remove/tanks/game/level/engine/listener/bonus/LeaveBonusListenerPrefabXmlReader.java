package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.SubEntityListenerPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusListenerPrefabXmlReader implements SubEntityListenerPrefabXmlReader<LeaveBonusListenerPrefab> {
    private static final String CHANCE_ELEMENT = "chance";

    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public LeaveBonusListenerPrefabXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    @Override
    public LeaveBonusListenerPrefab readEntityListenerPrefab(XmlReader.Element element, int priority) {
        try {
             return new LeaveBonusListenerPrefab(
                     priority,
                     readEntityPrefabCodes(element),
                     readChance(element)
             );
        } catch (Exception e) {
            throw new EntityListenerPrefabXmlReadException(element, e);
        }
    }

    private List<String> readEntityPrefabCodes(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCodes(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODES_ELEMENT));
    }

    private float readChance(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(CHANCE_ELEMENT).getText().trim());
    }

    @Override
    public ListenerType getReaderType() {
        return ListenerType.LeaveBonusListener;
    }
}
