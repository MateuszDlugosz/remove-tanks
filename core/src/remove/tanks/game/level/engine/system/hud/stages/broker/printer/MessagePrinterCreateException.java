package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create message printer from prototype %s.";

    public MessagePrinterCreateException(MessagePrinterPrototype prototype, Throwable cause) {
        super(String .format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
