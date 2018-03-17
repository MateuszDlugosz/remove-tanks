package remove.tanks.game.audio.music.event;

import remove.tanks.game.audio.music.MusicChannelName;

/**
 * @author Mateusz Długosz
 */
public final class PauseMusicEvent {
    private final MusicChannelName musicChannelName;

    public PauseMusicEvent(MusicChannelName musicChannelName) {
        this.musicChannelName = musicChannelName;
    }

    public MusicChannelName getMusicChannelName() {
        return musicChannelName;
    }
}
