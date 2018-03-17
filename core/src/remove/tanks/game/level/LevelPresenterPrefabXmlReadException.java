package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenterPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read level presenter prefab from file %s.";

    public LevelPresenterPrefabXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
