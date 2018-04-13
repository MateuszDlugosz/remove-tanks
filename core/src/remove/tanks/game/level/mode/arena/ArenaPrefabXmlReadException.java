package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read arena prefab from file %s.";

    public ArenaPrefabXmlReadException(FileHandle fileHandle, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fileHandle), cause);
    }
}
