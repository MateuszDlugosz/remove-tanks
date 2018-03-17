package remove.tanks.game.level.event.music;

import com.badlogic.gdx.audio.Music;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEvent implements Event {
    private final Music music;
    private final MusicChannelName musicChannelName;

    public PlayMusicEvent(Music music, MusicChannelName musicChannelName) {
        this.music = music;
        this.musicChannelName = musicChannelName;
    }

    public Music getMusic() {
        return music;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }
}
