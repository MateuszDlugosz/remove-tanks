package remove.tanks.game.level.engine.system.layer;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemPrototype extends LayerRenderSystemPrototype {
    public GroundLayerRenderSystemPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
