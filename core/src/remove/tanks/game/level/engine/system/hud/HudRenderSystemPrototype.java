package remove.tanks.game.level.engine.system.hud;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrototype;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototype;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystemPrototype extends EntitySystemPrototype {
    private final HudStagePrototype hudStagePrototype;

    public HudRenderSystemPrototype(int priority, HudStagePrototype hudStagePrototype) {
        super(priority);
        this.hudStagePrototype = hudStagePrototype;
    }

    public HudStagePrototype getHudStagePrototype() {
        return hudStagePrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hudStagePrototype", hudStagePrototype)
                .toString();
    }
}
