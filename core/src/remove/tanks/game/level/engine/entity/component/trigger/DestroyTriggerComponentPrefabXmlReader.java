package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.event.EntityEventPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerComponentPrefabXmlReader extends AbstractTriggerComponentPrefabXmlReader<DestroyTriggerComponentPrefab> {
    public DestroyTriggerComponentPrefabXmlReader(EntityEventPrefabXmlReader entityEventPrefabXmlReader) {
        super(entityEventPrefabXmlReader);
    }

    @Override
    protected DestroyTriggerComponentPrefab createComponentPrefab(List<EntityEventPrefab> entityEventPrefabs) {
        return new DestroyTriggerComponentPrefab(entityEventPrefabs);
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DestroyTriggerComponent;
    }
}
