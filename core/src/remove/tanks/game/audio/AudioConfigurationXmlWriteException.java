package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationXmlWriteException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot write audio configuration to xml string.";

    public AudioConfigurationXmlWriteException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
