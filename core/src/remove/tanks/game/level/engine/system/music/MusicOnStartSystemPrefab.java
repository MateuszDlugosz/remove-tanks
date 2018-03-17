package remove.tanks.game.level.engine.system.music;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemPrefab extends EntitySystemPrefab {
    private final MusicPrefab musicPrefab;
    private final MusicChannelName musicChannelName;

    public MusicOnStartSystemPrefab(int priority, MusicPrefab musicPrefab, MusicChannelName musicChannelName) {
        super(priority);
        this.musicPrefab = musicPrefab;
        this.musicChannelName = musicChannelName;
    }

    public MusicPrefab getMusicPrefab() {
        return musicPrefab;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("musicPrefab", musicPrefab)
                .add("musicChannelName", musicChannelName)
                .toString();
    }
}
