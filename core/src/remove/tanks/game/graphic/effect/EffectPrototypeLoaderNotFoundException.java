package remove.tanks.game.graphic.effect;

/**
 * @author Mateusz Długosz
 */
public final class EffectPrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Effect prototype loader of %s not found.";

    public EffectPrototypeLoaderNotFoundException(EffectType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
