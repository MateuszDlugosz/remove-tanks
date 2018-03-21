package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class BombRenderLayerComponentPrefab extends ComponentPrefab {
    public static final BombRenderLayerComponentPrefab INSTANCE = new BombRenderLayerComponentPrefab();

    private BombRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
