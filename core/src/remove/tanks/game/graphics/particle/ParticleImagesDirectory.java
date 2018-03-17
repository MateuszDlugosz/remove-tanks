package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleImagesDirectory {
    private final FileHandle fileHandle;

    public ParticleImagesDirectory(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}
