package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationConvertException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot convert audio configuration.";

    public AudioConfigurationConvertException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
