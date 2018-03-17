package remove.tanks.game.audio.sound;

/**
 * @author Mateusz Długosz
 */
public final class SoundCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sound from prefab %s.";

    public SoundCreateException(SoundPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
