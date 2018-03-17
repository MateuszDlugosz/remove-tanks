package remove.tanks.game.audio;

import remove.tanks.game.audio.music.MusicPlayer;
import remove.tanks.game.audio.music.MusicPlayerFactory;
import remove.tanks.game.audio.sound.SoundPlayer;
import remove.tanks.game.audio.sound.SoundPlayerFactory;

/**
 * @author Mateusz Długosz
 */
public final class AudioPlayerFactory {
    private final SoundPlayerFactory soundPlayerFactory;
    private final MusicPlayerFactory musicPlayerFactory;

    public AudioPlayerFactory(SoundPlayerFactory soundPlayerFactory, MusicPlayerFactory musicPlayerFactory) {
        this.soundPlayerFactory = soundPlayerFactory;
        this.musicPlayerFactory = musicPlayerFactory;
    }

    public AudioPlayer createAudioPlayer() {
        try {
            return new AudioPlayer(
                    createSoundPlayer(),
                    createMusicPlayer()
            );
        } catch (Exception e) {
            throw new AudioPlayerCreateException(e);
        }
    }

    private SoundPlayer createSoundPlayer() {
        return soundPlayerFactory.createSoundPlayer();
    }

    private MusicPlayer createMusicPlayer() {
        return musicPlayerFactory.createMusicPlayer();
    }
}
