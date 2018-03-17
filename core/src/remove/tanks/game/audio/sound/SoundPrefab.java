package remove.tanks.game.audio.sound;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class SoundPrefab extends Prefab {
    private final String filename;

    public SoundPrefab(String filename) {
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
