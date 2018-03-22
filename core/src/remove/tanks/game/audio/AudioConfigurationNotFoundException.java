package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Audio configuration of %s channel not found.";

    public AudioConfigurationNotFoundException(String channelName) {
        super(String.format(MESSAGE_TEMPLATE, channelName));
    }
}
