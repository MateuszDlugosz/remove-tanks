package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ResourceAlreadyExistsException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "LevelResource named %s already exists.";

    public ResourceAlreadyExistsException(String name) {
        super(String.format(MESSAGE_TEMPLATE, name));
    }
}
