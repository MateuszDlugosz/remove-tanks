package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEvent implements Event {
    private final String id;

    public ActivateAutoSpawnerEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
