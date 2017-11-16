package remove.tanks.game.graphic.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpriteCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sprite from prototype %s.";

    public SpriteCreateException(SpritePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
