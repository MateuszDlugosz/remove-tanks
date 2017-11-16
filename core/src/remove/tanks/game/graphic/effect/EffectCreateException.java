package remove.tanks.game.graphic.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create effect from prototype %s.";

    public EffectCreateException(EffectPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
