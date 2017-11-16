package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelDisposer {
    public void disposeLevel(Level level) {
        level.getResourceRegistry().dispose();
    }
}
