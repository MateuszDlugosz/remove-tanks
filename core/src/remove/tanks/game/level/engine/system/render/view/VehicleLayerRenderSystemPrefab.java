package remove.tanks.game.level.engine.system.render.view;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemPrefab extends AbstractLayerRenderSystemPrefab {
    public VehicleLayerRenderSystemPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
