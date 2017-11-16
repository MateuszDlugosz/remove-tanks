package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "LevelResource named %s not found.";

    public ResourceNotFoundException(String name) {
        super(String.format(MESSAGE_TEMPLATE, name));
    }
}
