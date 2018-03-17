package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class IncompatibleResourceObjectClassException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Resource object has %s but expected is %s.";

    public IncompatibleResourceObjectClassException(Class<?> currentClass, Class<?> expectedClass) {
        super(String.format(MESSAGE_TEMPLATE, currentClass, expectedClass));
    }
}
