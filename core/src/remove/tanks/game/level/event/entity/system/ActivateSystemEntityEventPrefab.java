package remove.tanks.game.level.event.entity.system;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEntityEventPrefab extends EntityEventPrefab {
    private final String systemClass;

    public ActivateSystemEntityEventPrefab(String systemClass) {
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
