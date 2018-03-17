package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceAlreadyExistsException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Resource %s already exists.";

    public ResourceAlreadyExistsException(ResourceType resourceType) {
        super(String.format(MESSAGE_TEMPLATE, resourceType));
    }
}
