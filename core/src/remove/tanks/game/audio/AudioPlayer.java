package remove.tanks.game.audio;

import com.google.common.eventbus.Subscribe;
import remove.tanks.game.audio.event.AudioOptionsChangedEvent;
import remove.tanks.game.audio.event.ChangeAudioOptionEvent;
import remove.tanks.game.audio.music.MusicPlayer;
import remove.tanks.game.audio.music.event.PauseMusicEvent;
import remove.tanks.game.audio.music.event.PlayMusicEvent;
import remove.tanks.game.audio.music.event.ResumeMusicEvent;
import remove.tanks.game.audio.music.event.StopMusicEvent;
import remove.tanks.game.audio.sound.SoundPlayer;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;

/**
 * @author Mateusz Długosz
 */
public final class AudioPlayer {
    private final SoundPlayer soundPlayer;
    private final MusicPlayer musicPlayer;
    private final AudioOptions audioOptions;

    public AudioPlayer(
            SoundPlayer soundPlayer,
            MusicPlayer musicPlayer,
            AudioOptions audioOptions
    ) {
        this.soundPlayer = soundPlayer;
        this.musicPlayer = musicPlayer;
        this.audioOptions = audioOptions;
    }

    public AudioOptions getAudioOptions() {
        return audioOptions;
    }

    @Subscribe
    public void handlePlaySoundEvent(PlaySoundEvent event) {
        long id = soundPlayer.playSound(event.getSound());
        event.getSound().setPan(
                id,
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.Pan),
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.SoundVolume)
        );
    }

    @Subscribe
    public void handlePlayMusicEvent(PlayMusicEvent event) {
        musicPlayer.stopMusic();
        musicPlayer.playMusic(event.getMusic());
        musicPlayer.getMusicPlayed().ifPresent(m -> m.setPan(
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.Pan),
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.MusicVolume)
        ));
    }

    @Subscribe
    public void handleStopMusicEvent(StopMusicEvent event) {
        musicPlayer.stopMusic();
    }

    @Subscribe
    public void handlePauseMusicEvent(PauseMusicEvent event) {
        musicPlayer.pauseMusic();
    }

    @Subscribe
    public void handleResumeMusicEvent(ResumeMusicEvent event) {
        musicPlayer.resumeMusic();
    }

    @Subscribe
    public void handleAudioOptionsChangedEvent(AudioOptionsChangedEvent event) {
        musicPlayer.getMusicPlayed().ifPresent(m -> m.setPan(
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.MusicVolume),
                audioOptions.getOptionValueAsFloat(AudioOptions.Option.Pan)
        ));
    }

    @Subscribe void handleChangeAudioOptionEvent(ChangeAudioOptionEvent event) {
        audioOptions.setOptionValue(event.getOption(), event.getNewValue());
    }
}
