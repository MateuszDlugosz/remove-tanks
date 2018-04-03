package remove.tanks.game.level.event.message;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEventFactory implements SubEventFactory<ClearMessagesEvent, ClearMessagesEventPrefab> {
    @Override
    public ClearMessagesEvent createEvent(ClearMessagesEventPrefab prefab, ResourceRegistry registry) {
        try {
            return ClearMessagesEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ClearMessagesEventPrefab> getFactoryType() {
        return ClearMessagesEventPrefab.class;
    }
}
