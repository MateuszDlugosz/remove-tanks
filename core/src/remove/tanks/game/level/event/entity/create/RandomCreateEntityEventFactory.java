package remove.tanks.game.level.event.entity.create;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.level.utility.create.CreateEntryFactory;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEntityEventFactory implements SubEntityEventFactory<RandomCreateEntityEvent, RandomCreateEntityEventPrefab> {
    private final CreateEntryFactory createEntryFactory;

    public RandomCreateEntityEventFactory(CreateEntryFactory createEntryFactory) {
        this.createEntryFactory = createEntryFactory;
    }

    @Override
    public RandomCreateEntityEvent createEntityEvent(RandomCreateEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RandomCreateEntityEvent(
                    createCreateEntries(
                            prefab.getCreateEntryPrefabs(),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    ),
                    entity
            );
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private List<CreateEntry> createCreateEntries(List<CreateEntryPrefab> prefabs, Scale scale) {
        return createEntryFactory.createCreateEntries(prefabs, scale);
    }

    @Override
    public Class<RandomCreateEntityEventPrefab> getFactoryType() {
        return RandomCreateEntityEventPrefab.class;
    }
}
