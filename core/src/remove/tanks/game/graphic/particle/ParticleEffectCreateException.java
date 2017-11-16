package remove.tanks.game.graphic.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create particle effect from prototype %s.";

    public ParticleEffectCreateException(ParticleEffectPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
