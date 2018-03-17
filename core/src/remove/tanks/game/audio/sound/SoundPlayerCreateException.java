package remove.tanks.game.audio.sound;

/**
 * @author Mateusz Długosz
 */
public final class SoundPlayerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sound player.";

    public SoundPlayerCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
