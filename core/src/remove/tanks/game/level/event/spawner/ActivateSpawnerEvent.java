package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEvent implements Event {
    private final String id;

    public ActivateSpawnerEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
