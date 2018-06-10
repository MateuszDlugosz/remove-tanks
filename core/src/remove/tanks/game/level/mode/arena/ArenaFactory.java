package remove.tanks.game.level.mode.arena;

/**
 * @author Mateusz Długosz
 */
public final class ArenaFactory {
    public Arena createArena(ArenaPrefab prefab) {
        try {
            return new Arena(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new ArenaCreateException(prefab, e);
        }
    }
}
