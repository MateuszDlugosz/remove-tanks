package remove.tanks.game.graphics.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Particle effect prefab reader of %s not found.";

    public ParticleEffectPrefabReaderNotFoundException(ParticleEffectType particleEffectType) {
        super(String.format(MESSAGE_TEMPLATE, particleEffectType));
    }
}
