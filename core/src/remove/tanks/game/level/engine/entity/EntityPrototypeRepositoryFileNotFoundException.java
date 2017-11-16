package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeRepositoryFileNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity prototype repository file %s not found.";

    public EntityPrototypeRepositoryFileNotFoundException(String filename) {
        super(String.format(MESSAGE_TEMPLATE, filename));
    }
}
