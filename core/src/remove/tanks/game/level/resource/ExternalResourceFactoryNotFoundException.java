package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ExternalResourceFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "External resource factory of object type %s named %s not found.";

    public ExternalResourceFactoryNotFoundException(String name, Class<?> type) {
        super(String.format(MESSAGE_TEMPLATE, type, name));
    }
}
