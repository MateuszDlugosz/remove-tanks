package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class OperationPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read operation prefab from file %s.";

    public OperationPrefabXmlReadException(FileHandle fileHandle, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fileHandle), cause);
    }
}
