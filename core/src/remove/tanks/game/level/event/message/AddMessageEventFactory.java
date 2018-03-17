package remove.tanks.game.level.event.message;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.stage.broker.message.Message;
import remove.tanks.game.level.utility.stage.broker.message.MessageFactory;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventFactory implements SubEventFactory<AddMessageEvent, AddMessageEventPrefab> {
    private final MessageFactory messageFactory;

    public AddMessageEventFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @Override
    public AddMessageEvent createEvent(AddMessageEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new AddMessageEvent(createMessage(prefab.getMessagePrefab()));
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    private Message createMessage(MessagePrefab prefab) {
        return messageFactory.createMessage(prefab);
    }

    @Override
    public Class<AddMessageEventPrefab> getFactoryType() {
        return AddMessageEventPrefab.class;
    }
}
