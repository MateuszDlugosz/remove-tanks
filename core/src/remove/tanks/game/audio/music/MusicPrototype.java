package remove.tanks.game.audio.music;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class MusicPrototype implements Serializable {
    private final String filename;

    public MusicPrototype(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filename", filename)
                .toString();
    }
}
