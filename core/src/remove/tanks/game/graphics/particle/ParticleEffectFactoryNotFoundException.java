package remove.tanks.game.graphics.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Particle effect factory of %s prefab not found.";

    public ParticleEffectFactoryNotFoundException(Class<? extends ParticleEffectPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
