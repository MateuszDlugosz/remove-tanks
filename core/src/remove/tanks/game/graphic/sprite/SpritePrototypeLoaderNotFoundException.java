package remove.tanks.game.graphic.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpritePrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Sprite prototype loader of %s not found.";

    public SpritePrototypeLoaderNotFoundException(SpriteType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
