package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class VehicleRenderLayerComponentPrefab extends ComponentPrefab {
    public static final VehicleRenderLayerComponentPrefab INSTANCE = new VehicleRenderLayerComponentPrefab();

    private VehicleRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
