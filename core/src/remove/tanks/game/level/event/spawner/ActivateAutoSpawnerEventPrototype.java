package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.level.event.EventPrototype;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEventPrototype implements EventPrototype {
    private final String id;

    public ActivateAutoSpawnerEventPrototype(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
