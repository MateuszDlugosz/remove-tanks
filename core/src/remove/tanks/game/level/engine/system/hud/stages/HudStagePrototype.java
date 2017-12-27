package remove.tanks.game.level.engine.system.hud.stages;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.hud.stages.message.MessageBarPrototype;
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
    private final MessageBarPrototype messageBarPrototype;

    public HudStagePrototype(
            List<WidgetPrototype> widgetPrototypes,
            StateBarPrototype stateBarPrototype,
            MessageBarPrototype messageBarPrototype
    ) {
        this.widgetPrototypes = widgetPrototypes;
        this.stateBarPrototype = stateBarPrototype;
        this.messageBarPrototype = messageBarPrototype;
    }

    public List<WidgetPrototype> getWidgetPrototypes() {
        return widgetPrototypes;
    }

    public StateBarPrototype getStateBarPrototype() {
        return stateBarPrototype;
    }

    public MessageBarPrototype getMessageBarPrototype() {
        return messageBarPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("widgetPrototypes", widgetPrototypes)
                .add("stateBarPrototype", stateBarPrototype)
                .add("messageBarPrototype", messageBarPrototype)
                .toString();
    }
}
