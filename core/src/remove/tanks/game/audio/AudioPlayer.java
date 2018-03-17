package remove.tanks.game.audio;

import com.google.common.eventbus.Subscribe;
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

    public AudioPlayer(SoundPlayer soundPlayer, MusicPlayer musicPlayer) {
        this.soundPlayer = soundPlayer;
        this.musicPlayer = musicPlayer;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    @Subscribe
    public void handlePlayMusicEvent(PlayMusicEvent event) {
        musicPlayer.playMusic(event.getMusicChannelName(), event.getMusic());
    }

    @Subscribe
    public void handleStopMusicEvent(StopMusicEvent event) {
        musicPlayer.stopMusic(event.getMusicChannelName());
    }

    @Subscribe
    public void handleResumeMusicEvent(ResumeMusicEvent event) {
        musicPlayer.resumeMusic(event.getMusicChannelName());
    }

    @Subscribe
    public void handlePauseMusicEvent(PauseMusicEvent event) {
        musicPlayer.pauseMusic(event.getMusicChannelName());
    }

    @Subscribe
    public void handlePlaySoundEvent(PlaySoundEvent event) {
        soundPlayer.playSound(event.getSoundChannelName(), event.getSound());
    }
}
