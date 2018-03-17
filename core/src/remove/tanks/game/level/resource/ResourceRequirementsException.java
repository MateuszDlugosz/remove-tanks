package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRequirementsException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Required resource %s not found.";

    public ResourceRequirementsException(ResourceType resourceType) {
        super(String.format(MESSAGE_TEMPLATE, resourceType));
    }
}
