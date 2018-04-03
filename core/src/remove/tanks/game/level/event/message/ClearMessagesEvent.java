package remove.tanks.game.level.event.message;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEvent implements Event {
    public static final ClearMessagesEvent INSTANCE = new ClearMessagesEvent();

    private ClearMessagesEvent() {}
}
