package remove.tanks.game.graphics.sprite;

/**
 * @author Mateusz Długosz
 */
public final class SpritePrefabReaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Sprite prefab reader of %s sprite not found.";

    public SpritePrefabReaderNotFoundException(SpriteType spriteType) {
        super(String.format(MESSAGE_TEMPLATE, spriteType));
    }
}
