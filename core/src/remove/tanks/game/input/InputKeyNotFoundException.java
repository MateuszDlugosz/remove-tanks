package remove.tanks.game.input;

/**
 * @author Mateusz Długosz
 */
public final class InputKeyNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Input key %s not found.";

    public InputKeyNotFoundException(InputKey inputKey) {
        super(String.format(MESSAGE_TEMPLATE, inputKey));
    }
}
