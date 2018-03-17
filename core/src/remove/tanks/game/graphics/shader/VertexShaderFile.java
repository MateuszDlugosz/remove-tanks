package remove.tanks.game.graphics.shader;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class VertexShaderFile {
    private final FileHandle fileHandle;

    public VertexShaderFile(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}
