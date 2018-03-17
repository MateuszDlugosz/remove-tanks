package remove.tanks.game.physics.fixture.hitbox;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create hit box from prefab %s.";

    public HitBoxCreateException(HitBoxPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
