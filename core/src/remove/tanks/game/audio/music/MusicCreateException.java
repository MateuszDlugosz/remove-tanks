package remove.tanks.game.audio.music;

/**
 * @author Mateusz Długosz
 */
public final class MusicCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create music from prototype %s.";

    public MusicCreateException(MusicPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
