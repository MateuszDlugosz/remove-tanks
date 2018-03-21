package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class BulletRenderLayerComponentPrefab extends ComponentPrefab {
    public static final BulletRenderLayerComponentPrefab INSTANCE = new BulletRenderLayerComponentPrefab();

    private BulletRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
