package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEvent implements Event {
    public static final ResetPointsMultiplierEvent INSTANCE = new ResetPointsMultiplierEvent();

    private ResetPointsMultiplierEvent() {}
}
