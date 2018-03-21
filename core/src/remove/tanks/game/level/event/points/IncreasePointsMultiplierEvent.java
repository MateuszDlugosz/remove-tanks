package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEvent implements Event {
    public static final IncreasePointsMultiplierEvent INSTANCE = new IncreasePointsMultiplierEvent();

    private IncreasePointsMultiplierEvent() {}
}
