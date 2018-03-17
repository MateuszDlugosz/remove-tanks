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
public final class CreateEventFactory implements SubEventFactory<CreateEvent, CreateEventPrefab> {
    private final CreateEntryFactory createEntryFactory;

    public CreateEventFactory(CreateEntryFactory createEntryFactory) {
        this.createEntryFactory = createEntryFactory;
    }

    @Override
    public CreateEvent createEvent(CreateEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new CreateEvent(
                    createCreateEntries(
                            prefab.getCreateEntryPrefabs(),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private List<CreateEntry> createCreateEntries(List<CreateEntryPrefab> createEntryPrefabs, Scale scale) {
        return createEntryFactory.createCreateEntries(createEntryPrefabs, scale);
    }

    @Override
    public Class<CreateEventPrefab> getFactoryType() {
        return CreateEventPrefab.class;
    }
}
