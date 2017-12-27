package remove.tanks.game.level.engine.system.hud.stages.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrototype implements Serializable {
    private final float time;
    private final TranslationEntryKey entryKey;

    public MessagePrototype(float time, TranslationEntryKey entryKey) {
        this.time = time;
        this.entryKey = entryKey;
    }

    public float getTime() {
        return time;
    }

    public TranslationEntryKey getEntryKey() {
        return entryKey;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("entryKey", entryKey)
                .toString();
    }
}
