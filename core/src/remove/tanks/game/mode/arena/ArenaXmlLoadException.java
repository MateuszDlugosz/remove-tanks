package remove.tanks.game.mode.arena;

/**
 * @author Mateusz Długosz
 */
public final class ArenaXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load arena from file %s.";

    public ArenaXmlLoadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
