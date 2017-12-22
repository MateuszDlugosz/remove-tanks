package remove.tanks.game.level.engine.system.hud.stages;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarPrototype;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStagePrototype implements Serializable {
    private final List<WidgetPrototype> widgetPrototypes;
    private final StateBarPrototype stateBarPrototype;

    public HudStagePrototype(
            List<WidgetPrototype> widgetPrototypes,
            StateBarPrototype stateBarPrototype
    ) {
        this.widgetPrototypes = widgetPrototypes;
        this.stateBarPrototype = stateBarPrototype;
    }

    public List<WidgetPrototype> getWidgetPrototypes() {
        return widgetPrototypes;
    }

    public StateBarPrototype getStateBarPrototype() {
        return stateBarPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("widgetPrototypes", widgetPrototypes)
                .add("stateBarPrototype", stateBarPrototype)
                .toString();
    }
}
