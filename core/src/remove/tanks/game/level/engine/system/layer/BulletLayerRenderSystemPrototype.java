package remove.tanks.game.level.engine.system.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.effect.EffectPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemPrototype extends LayerRenderSystemPrototype {
    public BulletLayerRenderSystemPrototype(EffectPrototype effectPrototype, int priority) {
        super(effectPrototype, priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
