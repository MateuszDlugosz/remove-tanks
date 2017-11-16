package remove.tanks.game.graphic.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create view from prototype %s.";

    public ViewCreateException(ViewPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
