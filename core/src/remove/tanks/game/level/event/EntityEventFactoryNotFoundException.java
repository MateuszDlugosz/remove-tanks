package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public final class EntityEventFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entity event factory of %s not found.";

    public EntityEventFactoryNotFoundException(Class<? extends EntityEventPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
