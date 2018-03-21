package remove.tanks.game.level.event.life;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEvent implements Event {
    public static final AddLifeEvent INSTANCE = new AddLifeEvent();

    private AddLifeEvent() {}
}
