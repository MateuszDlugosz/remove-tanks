package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity can not be created from prototype %s.";

    public EntityCreateException(String prototypeFilename, Throwable throwable) {
        super(String.format(MESSAGE_TEMPLATE, prototypeFilename), throwable);
    }
}
