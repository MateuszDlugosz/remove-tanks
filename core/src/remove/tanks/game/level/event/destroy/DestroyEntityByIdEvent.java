package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEvent implements Event {
    private final String id;

    public DestroyEntityByIdEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
