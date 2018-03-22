package remove.tanks.game.audio;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read audio configuration from file %s.";

    public AudioConfigurationXmlReadException(FileHandle fileHandle, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fileHandle), cause);
    }
}
