package remove.tanks.game.physics.fixture.hitbox;

/**
 * @author Mateusz Długosz
 */
public final class HitBoxCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create hit box from prototype %s.";

    public HitBoxCreateException(HitBoxPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
