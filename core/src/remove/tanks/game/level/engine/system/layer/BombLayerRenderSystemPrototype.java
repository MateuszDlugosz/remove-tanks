package remove.tanks.game.level.engine.system.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.effect.EffectPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemPrototype extends LayerRenderSystemPrototype {
    public BombLayerRenderSystemPrototype(int priority, EffectPrototype effectPrototype) {
        super(priority, effectPrototype);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
