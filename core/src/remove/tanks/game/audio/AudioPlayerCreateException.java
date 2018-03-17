package remove.tanks.game.audio;

/**
 * @author Mateusz Długosz
 */
public final class AudioPlayerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create audio player.";

    public AudioPlayerCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
