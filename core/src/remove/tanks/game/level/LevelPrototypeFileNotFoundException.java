package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrototypeFileNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Level prototype file %s not found.";

    public LevelPrototypeFileNotFoundException(String filename) {
        super(String.format(MESSAGE_TEMPLATE, filename));
    }
}
