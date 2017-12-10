package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load operation prototype from file %s.";

    public LevelSequenceXmlLoadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
