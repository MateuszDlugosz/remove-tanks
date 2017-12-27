package remove.tanks.game.level.event.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.hud.stages.message.MessagePrototype;
import remove.tanks.game.level.event.EventPrototype;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventPrototype implements EventPrototype {
    private final MessagePrototype messagePrototype;

    public AddMessageEventPrototype(MessagePrototype messagePrototype) {
        this.messagePrototype = messagePrototype;
    }

    public MessagePrototype getMessagePrototype() {
        return messagePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("messagePrototype", messagePrototype)
                .toString();
    }
}
