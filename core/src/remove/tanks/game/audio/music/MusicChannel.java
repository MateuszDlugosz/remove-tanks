package remove.tanks.game.audio.music;

import com.badlogic.gdx.audio.Music;
import com.google.common.eventbus.Subscribe;
import remove.tanks.game.audio.AudioConfiguration;
import remove.tanks.game.audio.event.AudioOptionChangedEvent;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class MusicChannel {
    private final MusicChannelName musicChannelName;
    private final AudioConfiguration audioConfiguration;
    private Music playedMusic;

    public MusicChannel(MusicChannelName musicChannelName, AudioConfiguration audioConfiguration) {
        this.musicChannelName = musicChannelName;
        this.audioConfiguration = audioConfiguration;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }

    public AudioConfiguration getAudioConfiguration() {
        return audioConfiguration;
    }

    public Optional<Music> getPlayedMusic() {
        return Optional.ofNullable(playedMusic);
    }

    public void playMusic(Music music) {
        getPlayedMusic().ifPresent(Music::stop);
        music.setPan(
                audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Pan),
                audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Volume)
        );
        music.play();
        playedMusic = music;
    }

    public void stopMusic() {
        getPlayedMusic().ifPresent(Music::stop);
    }

    public void resumeMusic() {
        getPlayedMusic().ifPresent(m -> {
            if (!m.isPlaying()) m.play();
        });
    }

    public void pauseMusic() {
        getPlayedMusic().ifPresent(Music::pause);
    }

    @Subscribe
    public void handleAudioOptionsChangedEvent(AudioOptionChangedEvent event) {
        getPlayedMusic().ifPresent(m ->
            m.setPan(
                    audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Pan),
                    audioConfiguration.getOptionValueAsFloat(AudioConfiguration.Option.Volume)
            )
        );
    }
}
