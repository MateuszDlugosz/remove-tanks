package remove.tanks.game.level.utility.spawner;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create spawner from prefab %s.";

    public SpawnerCreateException(SpawnerPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab));
    }
}
