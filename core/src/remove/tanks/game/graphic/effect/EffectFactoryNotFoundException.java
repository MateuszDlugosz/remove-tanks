package remove.tanks.game.graphic.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Effect factory of prototype %s not found.";

    public EffectFactoryNotFoundException(String prototypeClassName) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClassName));
    }
}
