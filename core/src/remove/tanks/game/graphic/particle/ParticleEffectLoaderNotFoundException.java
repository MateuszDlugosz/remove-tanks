package remove.tanks.game.graphic.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Particle effect prototype loader of %s not found.";

    public ParticleEffectLoaderNotFoundException(ParticleEffectType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
