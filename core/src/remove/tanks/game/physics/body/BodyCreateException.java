package remove.tanks.game.physics.body;

/**
 * @author Mateusz Długosz
 */
public final class BodyCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create body from prefab %s.";

    public BodyCreateException(BodyPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
