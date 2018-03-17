package remove.tanks.game.level.engine.entity.component.trigger;

import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.event.EntityEventPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerComponentPrefabXmlReader extends AbstractTriggerComponentPrefabXmlReader<CreateTriggerComponentPrefab> {
    public CreateTriggerComponentPrefabXmlReader(EntityEventPrefabXmlReader entityEventPrefabXmlReader) {
        super(entityEventPrefabXmlReader);
    }

    @Override
    protected CreateTriggerComponentPrefab createComponentPrefab(List<EntityEventPrefab> entityEventPrefabs) {
        return new CreateTriggerComponentPrefab(entityEventPrefabs);
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.CreateTriggerComponent;
    }
}
