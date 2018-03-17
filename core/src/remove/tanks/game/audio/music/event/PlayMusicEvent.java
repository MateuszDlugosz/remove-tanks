package remove.tanks.game.audio.music.event;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.audio.music.MusicChannelName;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEvent {
    private final MusicChannelName musicChannelName;
    private final Music music;

    public PlayMusicEvent(MusicChannelName musicChannelName, Music music) {
        this.musicChannelName = musicChannelName;
        this.music = music;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }

    public Music getMusic() {
        return music;
    }
}
