package remove.tanks.game.level.utility.stage.broker.face;

/**
 * @author Mateusz Długosz
 */
public final class FaceCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create face from prefab %s.";

    public FaceCreateException(FacePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
