package remove.tanks.game.level.utility.stage.broker.message;

import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class MessageFactory {
    public Message createMessage(MessagePrefab prefab) {
        try {
            return new Message(
                    createTimer(prefab.getTime()),
                    prefab.getEntryKey(),
                    prefab.getFaceId()
            );
        } catch (Exception e) {
            throw new MessageCreateException(prefab, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
