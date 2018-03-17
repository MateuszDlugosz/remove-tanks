package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Can not read entity prefab from file %s.";

    public EntityPrefabXmlReadException(String filename, Throwable throwable) {
        super(String.format(MESSAGE_TEMPLATE, filename), throwable);
    }
}
