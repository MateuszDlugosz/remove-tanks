package remove.tanks.game.graphic.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationPrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Animation prototype loader of %s not found.";

    public AnimationPrototypeLoaderNotFoundException(AnimationType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
