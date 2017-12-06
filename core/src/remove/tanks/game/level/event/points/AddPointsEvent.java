package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEvent implements Event {
    private final int points;

    public AddPointsEvent(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
