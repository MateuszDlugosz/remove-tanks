package remove.tanks.game.level.event.airplane;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEvent implements Event {
    public static final SpawnAirplaneEvent INSTANCE = new SpawnAirplaneEvent();

    private SpawnAirplaneEvent() {}
}
