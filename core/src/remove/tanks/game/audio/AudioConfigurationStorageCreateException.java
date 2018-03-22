package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create audio configuration storage.";

    public AudioConfigurationStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
