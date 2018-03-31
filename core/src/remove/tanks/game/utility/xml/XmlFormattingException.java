package remove.tanks.game.utility.xml;

/**
 * @author Mateusz Długosz
 */
public final class XmlFormattingException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot format xml string %s.";

    public XmlFormattingException(String xml, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, xml), cause);
    }
}
