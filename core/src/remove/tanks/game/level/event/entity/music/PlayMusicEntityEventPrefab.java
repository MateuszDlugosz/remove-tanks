package remove.tanks.game.level.event.entity.music;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEntityEventPrefab extends EntityEventPrefab {
    private final MusicPrefab musicPrefab;
    private final MusicChannelName musicChannelName;

    public PlayMusicEntityEventPrefab(MusicPrefab musicPrefab, MusicChannelName musicChannelName) {
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
