package remove.tanks.game.graphic.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Particle effect factory of %s not found.";

    public ParticleEffectFactoryNotFoundException(Class<? extends ParticleEffectPrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
