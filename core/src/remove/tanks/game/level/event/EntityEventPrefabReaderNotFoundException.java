package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EntityEventPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity event prefab reader of %s not found.";

    public EntityEventPrefabReaderNotFoundException(EntityEventType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
