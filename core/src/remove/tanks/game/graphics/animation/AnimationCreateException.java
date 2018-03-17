package remove.tanks.game.graphics.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create animation from prefab %s.";

    public AnimationCreateException(AnimationPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
