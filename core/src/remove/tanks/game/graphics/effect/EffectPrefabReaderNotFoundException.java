package remove.tanks.game.graphics.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectPrefabReaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Effect prefab reader of %s not found.";

    public EffectPrefabReaderNotFoundException(EffectType effectType) {
        super(String.format(MESSAGE_TEMPLATE, effectType));
    }
}
