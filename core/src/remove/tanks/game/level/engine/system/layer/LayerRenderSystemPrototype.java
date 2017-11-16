package remove.tanks.game.level.engine.system.layer;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.effect.EffectPrototype;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemPrototype extends EntitySystemPrototype {
    private final EffectPrototype effectPrototype;

    public LayerRenderSystemPrototype(EffectPrototype effectPrototype, int priority) {
        super(priority);
        this.effectPrototype = effectPrototype;
    }

    public EffectPrototype getEffectPrototype() {
        return effectPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectPrototype", effectPrototype)
                .toString();
    }
}
