package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.event.EntityEventPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerComponentPrefabXmlReader extends AbstractTriggerComponentPrefabXmlReader<HitTriggerComponentPrefab> {
    public HitTriggerComponentPrefabXmlReader(EntityEventPrefabXmlReader entityEventPrefabXmlReader) {
        super(entityEventPrefabXmlReader);
    }

    @Override
    protected HitTriggerComponentPrefab createComponentPrefab(List<EntityEventPrefab> entityEventPrefabs) {
        return new HitTriggerComponentPrefab(entityEventPrefabs);
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.HitTriggerComponent;
    }
}
