package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class GlobalResourceObjectNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Global resource object %s not found.";

    public GlobalResourceObjectNotFoundException(ResourceType resourceType) {
        super(String.format(MESSAGE_TEMPLATE, resourceType));
    }
}
