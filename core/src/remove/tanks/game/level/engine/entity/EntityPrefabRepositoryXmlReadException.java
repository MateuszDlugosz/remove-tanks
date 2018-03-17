package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabRepositoryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read entity prefab filename repository from file %s.";

    public EntityPrefabRepositoryXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
