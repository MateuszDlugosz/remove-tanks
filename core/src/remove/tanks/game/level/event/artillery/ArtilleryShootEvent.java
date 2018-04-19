package remove.tanks.game.level.event.artillery;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEvent implements Event {
    public static final ArtilleryShootEvent INSTANCE = new ArtilleryShootEvent();

    private ArtilleryShootEvent() {}
}
