package remove.tanks.game.audio.music.event;

import remove.tanks.game.audio.music.MusicChannelName;

/**
 * @author Mateusz Długosz
 */
public final class ResumeMusicEvent {
    private final MusicChannelName musicChannelName;

    public ResumeMusicEvent(MusicChannelName musicChannelName) {
        this.musicChannelName = musicChannelName;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }
}
