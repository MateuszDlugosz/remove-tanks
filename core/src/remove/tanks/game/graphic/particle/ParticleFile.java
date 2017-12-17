package remove.tanks.game.graphic.particle;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ParticleFile {
    private final FileHandle fileHandle;

    public ParticleFile(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }
}
