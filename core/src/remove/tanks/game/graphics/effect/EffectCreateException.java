package remove.tanks.game.graphics.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create effect from prefab %s.";

    public EffectCreateException(EffectPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
