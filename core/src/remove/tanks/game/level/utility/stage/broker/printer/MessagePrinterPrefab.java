package remove.tanks.game.level.utility.stage.broker.printer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterPrefab extends Prefab {
    private final float time;
    private final SoundPrefab soundPrefab;
    private final SoundChannelName soundChannelName;

    public MessagePrinterPrefab(float time, SoundPrefab soundPrefab, SoundChannelName soundChannelName) {
        this.time = time;
        this.soundPrefab = soundPrefab;
        this.soundChannelName = soundChannelName;
    }

    public float getTime() {
        return time;
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
                .add("time", time)
                .add("soundPrefab", soundPrefab)
                .add("soundChannelName", soundChannelName)
                .toString();
    }
}
