package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class MusicPlayer {
    private final Map<MusicChannelName, MusicChannel> musicChannels;

    public MusicPlayer(Map<MusicChannelName, MusicChannel> musicChannels) {
        this.musicChannels = musicChannels;
    }

    public MusicChannel getMusicChannel(MusicChannelName musicChannelName) {
        return musicChannels.get(musicChannelName);
    }

    public void playMusic(MusicChannelName musicChannelName, Music music) {
        musicChannels.get(musicChannelName).playMusic(music);
    }

    public void stopMusic(MusicChannelName musicChannelName) {
        getMusicChannel(musicChannelName).stopMusic();
    }

    public void resumeMusic(MusicChannelName musicChannelName) {
        getMusicChannel(musicChannelName).resumeMusic();
    }

    public void pauseMusic(MusicChannelName musicChannelName) {
        getMusicChannel(musicChannelName).pauseMusic();
    }
}
