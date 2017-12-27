package remove.tanks.game.level.engine.system.hud.stages.broker;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message bar from prototype %s.";

    public MessageBarCreateException(MessageBarPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
