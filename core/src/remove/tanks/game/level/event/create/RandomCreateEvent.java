package remove.tanks.game.level.event.create;

import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.utility.create.CreateEntry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEvent implements Event {
    private final List<CreateEntry> createEntries;

    public RandomCreateEvent(List<CreateEntry> createEntries) {
        this.createEntries = createEntries;
    }

    public List<CreateEntry> getCreateEntries() {
        return createEntries;
    }
}
