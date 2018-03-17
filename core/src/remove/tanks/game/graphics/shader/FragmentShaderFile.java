package remove.tanks.game.graphics.shader;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class FragmentShaderFile {
    private final FileHandle fileHandle;

    public FragmentShaderFile(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}
