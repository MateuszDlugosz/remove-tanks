package remove.tanks.game.level.engine.system.audio;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.music.MusicPrototype;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemPrototype extends EntitySystemPrototype {
    private final MusicPrototype musicPrototype;

    public MusicOnStartSystemPrototype(int priority, MusicPrototype musicPrototype) {
        super(priority);
        this.musicPrototype = musicPrototype;
    }

    public MusicPrototype getMusicPrototype() {
        return musicPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("musicPrototype", musicPrototype)
                .toString();
    }
}
