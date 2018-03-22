package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationSaveException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot save audio configurations.";

    public AudioConfigurationSaveException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
