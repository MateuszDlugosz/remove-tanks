package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create resource %s.";

    public ResourceCreateException(ResourceType resourceType, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, resourceType), cause);
    }
}
