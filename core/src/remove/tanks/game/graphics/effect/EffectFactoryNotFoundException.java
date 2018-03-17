package remove.tanks.game.graphics.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Effect factory of prefab %s not found.";

    public EffectFactoryNotFoundException(Class<? extends EffectPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
