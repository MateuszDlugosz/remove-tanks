package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.event.EntityEventPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerComponentPrefabXmlReader<T extends AbstractTriggerComponentPrefab> implements SubComponentPrefabXmlReader<T> {
    private final EntityEventPrefabXmlReader entityEventPrefabXmlReader;

    public AbstractTriggerComponentPrefabXmlReader(EntityEventPrefabXmlReader entityEventPrefabXmlReader) {
        this.entityEventPrefabXmlReader = entityEventPrefabXmlReader;
    }

    @Override
    public final T readComponentPrefab(XmlReader.Element element) {
        try {
            return createComponentPrefab(readEntityEventPrefabs(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    protected abstract T createComponentPrefab(List<EntityEventPrefab> entityEventPrefabs);

    private List<EntityEventPrefab> readEntityEventPrefabs(XmlReader.Element element) {
        return entityEventPrefabXmlReader.readEntityEventPrefabs(
                element.getChildByName(EntityEventPrefabXmlReader.ENTITY_EVENTS_ELEMENT));
    }
}
