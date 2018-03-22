package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationInitializeException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialze audio configurations.";

    public AudioConfigurationInitializeException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
