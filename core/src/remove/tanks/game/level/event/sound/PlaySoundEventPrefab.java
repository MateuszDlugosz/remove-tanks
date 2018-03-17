package remove.tanks.game.level.event.sound;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEventPrefab extends EventPrefab {
    private final SoundPrefab soundPrefab;
    private final SoundChannelName soundChannelName;

    public PlaySoundEventPrefab(SoundPrefab soundPrefab, SoundChannelName soundChannelName) {
        this.soundPrefab = soundPrefab;
        this.soundChannelName = soundChannelName;
    }

    public SoundPrefab getSoundPrefab() {
        return soundPrefab;
    }

    public SoundChannelName getSoundChannelName() {
        return soundChannelName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("soundPrefab", soundPrefab)
                .add("soundChannelName", soundChannelName)
                .toString();
    }
}
