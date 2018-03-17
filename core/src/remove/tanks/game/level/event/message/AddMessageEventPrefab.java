package remove.tanks.game.level.event.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventPrefab extends EventPrefab {
    private final MessagePrefab messagePrefab;

    public AddMessageEventPrefab(MessagePrefab messagePrefab) {
        this.messagePrefab = messagePrefab;
    }

    public MessagePrefab getMessagePrefab() {
        return messagePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("messagePrefab", messagePrefab)
                .toString();
    }
}
