package remove.tanks.game.audio.sound;

/**
 * @author Mateusz Długosz
 */
public final class SoundCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sound from prototype %s.";

    public SoundCreateException(SoundPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
