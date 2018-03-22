package remove.tanks.game.audio;

import com.badlogic.gdx.files.FileHandle;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.sound.SoundChannelName;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationFileHandleRepository {
    private final Map<SoundChannelName, FileHandle> soundEmptyConfigurationFiles;
    private final Map<MusicChannelName, FileHandle> musicEmptyConfigurationFiles;
    private final Map<SoundChannelName, FileHandle> soundLocalConfigurationFiles;
    private final Map<MusicChannelName, FileHandle> musicLocalConfigurationFiles;

    public AudioConfigurationFileHandleRepository(
            Map<SoundChannelName, FileHandle> soundEmptyConfigurationFiles,
            Map<MusicChannelName, FileHandle> musicEmptyConfigurationFiles,
            Map<SoundChannelName, FileHandle> soundLocalConfigurationFiles,
            Map<MusicChannelName, FileHandle> musicLocalConfigurationFiles
    ) {
        this.soundEmptyConfigurationFiles = soundEmptyConfigurationFiles;
        this.musicEmptyConfigurationFiles = musicEmptyConfigurationFiles;
        this.soundLocalConfigurationFiles = soundLocalConfigurationFiles;
        this.musicLocalConfigurationFiles = musicLocalConfigurationFiles;
    }

    public FileHandle getSoundEmptyConfigurationFileHandle(SoundChannelName soundChannelName) {
        if (!soundEmptyConfigurationFiles.containsKey(soundChannelName)) {
            throw new AudioConfigurationFileHandleNotFoundException(soundChannelName.name());
        }
        return soundEmptyConfigurationFiles.get(soundChannelName);
    }

    public FileHandle getMusicEmptyConfigurationFileHandle(MusicChannelName musicChannelName) {
        if (!musicEmptyConfigurationFiles.containsKey(musicChannelName)) {
            throw new AudioConfigurationFileHandleNotFoundException(musicChannelName.name());
        }
        return musicEmptyConfigurationFiles.get(musicChannelName);
    }

    public FileHandle getSoundLocalConfigurationFileHandle(SoundChannelName soundChannelName) {
        if (!soundLocalConfigurationFiles.containsKey(soundChannelName)) {
            throw new AudioConfigurationFileHandleNotFoundException(soundChannelName.name());
        }
        return soundLocalConfigurationFiles.get(soundChannelName);
    }

    public FileHandle getMusicLocalConfigurationFileHandle(MusicChannelName musicChannelName) {
        if (!musicLocalConfigurationFiles.containsKey(musicChannelName)) {
            throw new AudioConfigurationFileHandleNotFoundException(musicChannelName.name());
        }
        return musicLocalConfigurationFiles.get(musicChannelName);
    }
}
