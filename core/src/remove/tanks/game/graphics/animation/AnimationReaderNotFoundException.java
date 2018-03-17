package remove.tanks.game.graphics.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Animation reader of %s prefab not found.";

    public AnimationReaderNotFoundException(AnimationType animationType) {
        super(String.format(MESSAGE_TEMPLATE, animationType));
    }
}
