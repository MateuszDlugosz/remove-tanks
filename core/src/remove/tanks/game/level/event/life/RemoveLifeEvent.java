package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEvent implements Event {
    public static final RemoveLifeEvent INSTANCE = new RemoveLifeEvent();

    private RemoveLifeEvent() {}
}
