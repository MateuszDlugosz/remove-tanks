package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionRenderLayerComponentPrefab extends ComponentPrefab {
    public static final ExplosionRenderLayerComponentPrefab INSTANCE = new ExplosionRenderLayerComponentPrefab();

    private ExplosionRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
