package remove.tanks.game.utility.properties;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesXmlWriteException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot write properties to xml string.";

    public PropertiesXmlWriteException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
