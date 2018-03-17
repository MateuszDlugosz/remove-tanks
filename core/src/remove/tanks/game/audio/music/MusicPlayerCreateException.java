package remove.tanks.game.audio.music;

/**
 * @author Mateusz Długosz
 */
public final class MusicPlayerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create music player.";

    public MusicPlayerCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
