package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRegistryCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create resource registry.";

    public ResourceRegistryCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
