package remove.tanks.game.level.event.create;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
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
public final class RandomCreateEventFactory implements SubEventFactory<RandomCreateEvent, RandomCreateEventPrefab> {
    private final CreateEntryFactory createEntryFactory;

    public RandomCreateEventFactory(CreateEntryFactory createEntryFactory) {
        this.createEntryFactory = createEntryFactory;
    }

    @Override
    public RandomCreateEvent createEvent(RandomCreateEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new RandomCreateEvent(
                    createCreateEntries(
                            prefab.getCreateEntryPrefabs(),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private List<CreateEntry> createCreateEntries(List<CreateEntryPrefab> prefabs, Scale scale) {
        return createEntryFactory.createCreateEntries(prefabs, scale);
    }

    @Override
    public Class<RandomCreateEventPrefab> getFactoryType() {
        return RandomCreateEventPrefab.class;
    }
}
