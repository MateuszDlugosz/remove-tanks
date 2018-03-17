package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Resource factory of %s not found.";

    public ResourceFactoryNotFoundException(ResourceType resourceType) {
        super(String.format(MESSAGE_TEMPLATE, resourceType));
    }
}
