package remove.tanks.game.level.mode.arena;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ArenaStorage {
    private final Map<String, Arena> arenas;

    ArenaStorage(Map<String, Arena> arenas) {
        this.arenas = arenas;
    }

    public Arena getArena(String title) {
        if (!arenas.containsKey(title)) {
            throw new ArenaNotFoundException(title);
        }
        return arenas.get(title);
    }
}
