package remove.tanks.game.graphic.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Animation factory of prototype %s not found.";

    public AnimationFactoryNotFoundException(String prototypeClassName) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClassName));
    }
}
