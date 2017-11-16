package remove.tanks.game.graphic.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpriteFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Sprite factory of prototype %s not found.";

    public SpriteFactoryNotFoundException(String prototypeClassName) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClassName));
    }
}
