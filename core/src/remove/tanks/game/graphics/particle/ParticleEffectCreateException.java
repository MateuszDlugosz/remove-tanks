package remove.tanks.game.graphics.particle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create particle effect from prefab %s.";

    public ParticleEffectCreateException(ParticleEffectPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
