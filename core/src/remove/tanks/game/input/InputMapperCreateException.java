package remove.tanks.game.input;

/**
 * @author Mateusz Długosz
 */
public final class InputMapperCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create input mapper.";

    public InputMapperCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
