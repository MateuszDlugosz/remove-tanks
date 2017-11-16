package remove.tanks.game.graphic.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create animation from prototype %s.";

    public AnimationCreateException(AnimationPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
