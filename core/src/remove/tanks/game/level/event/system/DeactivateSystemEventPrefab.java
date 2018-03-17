package remove.tanks.game.level.event.system;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEventPrefab extends EventPrefab {
    private final String systemClass;

    public DeactivateSystemEventPrefab(String systemClass) {
        this.systemClass = systemClass;
    }

    public String getSystemClass() {
        return systemClass;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("systemClass", systemClass)
                .toString();
    }
}
