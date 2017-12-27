package remove.tanks.game.level.engine.system.hud.stages.message;

import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class MessageFactory {
    public Message createMessage(MessagePrototype prototype) {
        try {
            return new Message(
                    createTimer(prototype.getTime()),
                    prototype.getEntryKey()
            );
        } catch (Exception e) {
            throw new MessageCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
