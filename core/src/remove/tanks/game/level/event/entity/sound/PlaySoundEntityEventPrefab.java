package remove.tanks.game.level.event.entity.sound;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEntityEventPrefab extends EntityEventPrefab {
    private final SoundPrefab soundPrefab;
    private final SoundChannelName soundChannelName;

    public PlaySoundEntityEventPrefab(SoundPrefab soundPrefab, SoundChannelName soundChannelName) {
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
