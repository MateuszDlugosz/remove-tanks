package remove.tanks.game.application.context.configuration;

/**
 * @author Mateusz Długosz
 */
public final class OptionNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Option %s not found.";

    public OptionNotFoundException(String name) {
        super(String.format(MESSAGE_TEMPLATE, name));
    }
}
