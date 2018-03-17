package remove.tanks.game.level.event.entity.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEntityEventPrefab extends EntityEventPrefab {
    private final MessagePrefab messagePrefab;

    public AddMessageEntityEventPrefab(MessagePrefab messagePrefab) {
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
