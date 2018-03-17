package remove.tanks.game.level.event.entity.message;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.stage.broker.message.Message;
import remove.tanks.game.level.utility.stage.broker.message.MessageFactory;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEntityEventFactory implements SubEntityEventFactory<AddMessageEntityEvent, AddMessageEntityEventPrefab> {
    private final MessageFactory messageFactory;

    public AddMessageEntityEventFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @Override
    public AddMessageEntityEvent createEntityEvent(AddMessageEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AddMessageEntityEvent(entity, createMessage(prefab.getMessagePrefab()));
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    private Message createMessage(MessagePrefab prefab) {
        return messageFactory.createMessage(prefab);
    }

    @Override
    public Class<AddMessageEntityEventPrefab> getFactoryType() {
        return AddMessageEntityEventPrefab.class;
    }
}
