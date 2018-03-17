package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read level prefab from file %s.";

    public LevelPrefabXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
