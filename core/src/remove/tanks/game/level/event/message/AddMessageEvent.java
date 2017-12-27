package remove.tanks.game.level.event.message;

import remove.tanks.game.level.engine.system.hud.stages.broker.message.Message;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEvent implements Event {
    private final Message message;

    public AddMessageEvent(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
