package remove.tanks.game.level.engine.system.hud.stages.message;

/**
 * @author Mateusz Długosz
 */
public final class MessageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message from prototype %s.";

    public MessageCreateException(MessagePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
