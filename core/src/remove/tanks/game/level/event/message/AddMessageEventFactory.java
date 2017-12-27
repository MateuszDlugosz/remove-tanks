package remove.tanks.game.level.event.message;

import remove.tanks.game.level.engine.system.hud.stages.message.Message;
import remove.tanks.game.level.engine.system.hud.stages.message.MessageFactory;
import remove.tanks.game.level.engine.system.hud.stages.message.MessagePrototype;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.RegistrableEventFactory;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventFactory
        implements RegistrableEventFactory<AddMessageEvent, AddMessageEventPrototype>
{
    private final MessageFactory messageFactory;

    public AddMessageEventFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @Override
    public AddMessageEvent createEvent(AddMessageEventPrototype prototype) {
        try {
            return new AddMessageEvent(
                    createMessage(prototype.getMessagePrototype())
            );
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }

    private Message createMessage(MessagePrototype prototype) {
        return messageFactory.createMessage(prototype);
    }

    @Override
    public Class<AddMessageEventPrototype> getFactoryType() {
        return AddMessageEventPrototype.class;
    }
}
