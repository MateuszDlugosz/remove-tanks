package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class BonusRenderLayerComponentPrefab extends ComponentPrefab {
    public static final BonusRenderLayerComponentPrefab INSTANCE = new BonusRenderLayerComponentPrefab();

    private BonusRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
