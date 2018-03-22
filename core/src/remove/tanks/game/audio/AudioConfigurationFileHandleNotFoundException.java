package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationFileHandleNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Audio configuration file handle of %s channel not found.";

    public AudioConfigurationFileHandleNotFoundException(String channelName) {
        super(String.format(MESSAGE_TEMPLATE, channelName));
    }
}
