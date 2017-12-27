package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.audio.sound.SoundPrototype;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterPrototype implements Serializable {
    private final float time;
    private final SoundPrototype soundPrototype;

    public MessagePrinterPrototype(float time, SoundPrototype soundPrototype) {
        this.time = time;
        this.soundPrototype = soundPrototype;
    }

    public float getTime() {
        return time;
    }

    public SoundPrototype getSoundPrototype() {
        return soundPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("soundPrototype", soundPrototype)
                .toString();
    }
}
