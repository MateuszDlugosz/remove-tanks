package remove.tanks.game.graphics.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpriteCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sprite from prefab %s.";

    public SpriteCreateException(SpritePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
