package remove.tanks.game.level.utility.stage.broker.message;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrefab extends Prefab {
    private final float time;
    private final String entryKey;
    private final String faceId;

    public MessagePrefab(float time, String entryKey, String faceId) {
        this.time = time;
        this.entryKey = entryKey;
        this.faceId = faceId;
    }

    public float getTime() {
        return time;
    }

    public String getEntryKey() {
        return entryKey;
    }

    public String getFaceId() {
        return faceId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("time", time)
                .add("entryKey", entryKey)
                .add("faceId", faceId)
                .toString();
    }
}
