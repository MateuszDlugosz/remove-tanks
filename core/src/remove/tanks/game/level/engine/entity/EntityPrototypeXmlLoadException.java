package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Can not load entity prototype from file %s.";

    public EntityPrototypeXmlLoadException(String filename, Throwable throwable) {
        super(String.format(MESSAGE_TEMPLATE, filename), throwable);
    }
}
