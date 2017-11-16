package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Light factory of prototype %s not found.";

    public LightFactoryNotFoundException(String prototypeClassName) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClassName));
    }
}
