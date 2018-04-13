package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefabFilenameRepositoryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read arena prefab filename repository from file %s.";

    public ArenaPrefabFilenameRepositoryXmlReadException(FileHandle fileHandle, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fileHandle), cause);
    }
}
