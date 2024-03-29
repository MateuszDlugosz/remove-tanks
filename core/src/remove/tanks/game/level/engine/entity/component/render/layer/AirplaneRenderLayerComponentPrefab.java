package remove.tanks.game.level.engine.entity.component.render.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneRenderLayerComponentPrefab extends ComponentPrefab {
    public static final AirplaneRenderLayerComponentPrefab INSTANCE = new AirplaneRenderLayerComponentPrefab();

    private AirplaneRenderLayerComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
