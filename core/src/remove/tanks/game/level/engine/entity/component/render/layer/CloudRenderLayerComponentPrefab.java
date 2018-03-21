package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CloudRenderLayerComponentPrefab extends ComponentPrefab {
    public static final CloudRenderLayerComponentPrefab INSTANCE = new CloudRenderLayerComponentPrefab();

    private CloudRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
