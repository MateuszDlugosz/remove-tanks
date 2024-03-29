package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class GroundRenderLayerComponentPrefab extends ComponentPrefab {
    public static final GroundRenderLayerComponentPrefab INSTANCE = new GroundRenderLayerComponentPrefab();

    private GroundRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
