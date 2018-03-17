package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceIncompatibleTypeException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Resource is type of %s expected %s.";

    public ResourceIncompatibleTypeException(Class<?> currentType, Class<?> expectedType) {
        super(String.format(MESSAGE_TEMPLATE, currentType, expectedType));
    }
}
