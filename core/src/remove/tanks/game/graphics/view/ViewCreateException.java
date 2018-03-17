package remove.tanks.game.graphics.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create view from prefab %s.";

    public ViewCreateException(ViewPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
