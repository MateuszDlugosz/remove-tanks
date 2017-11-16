package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightPrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Light prototype loader of %s not found.";

    public LightPrototypeLoaderNotFoundException(LightType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
