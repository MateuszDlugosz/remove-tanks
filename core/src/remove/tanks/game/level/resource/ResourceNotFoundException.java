package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Resource %s not found.";

    public ResourceNotFoundException(ResourceType resourceType) {
        super(String.format(MESSAGE_TEMPLATE, resourceType));
    }
}
