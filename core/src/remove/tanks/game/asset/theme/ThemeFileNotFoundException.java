package remove.tanks.game.asset.theme;

/**
 * @author Mateusz Długosz
 */
public final class ThemeFileNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Theme file '%s' not found.";

    public ThemeFileNotFoundException(String filename) {
        super(String.format(MESSAGE_TEMPLATE, filename));
    }
}
