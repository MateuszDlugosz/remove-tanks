package remove.tanks.game.graphics.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpriteFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Sprite factory of prefab %s not found.";

    public SpriteFactoryNotFoundException(Class<? extends SpritePrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
