package remove.tanks.game.level.engine;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EnginePrototype implements Serializable {
    private final List<EntitySystemPrototype> systemsPrototypes;
    private final List<EntityListenerPrototype> listenersPrototypes;

    public EnginePrototype(
            List<EntitySystemPrototype> systemsPrototypes,
            List<EntityListenerPrototype> listenersPrototypes
    ) {
        this.systemsPrototypes = systemsPrototypes;
        this.listenersPrototypes = listenersPrototypes;
    }

    public List<EntitySystemPrototype> getSystemsPrototypes() {
        return systemsPrototypes;
    }

    public List<EntityListenerPrototype> getListenersPrototypes() {
        return listenersPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("systemsPrototypes", systemsPrototypes)
                .add("listenersPrototypes", listenersPrototypes)
                .toString();
    }
}
