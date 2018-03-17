package remove.tanks.game.level.utility.stage;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.utility.stage.broker.MessageBarPrefab;
import remove.tanks.game.level.utility.stage.state.StateBarPrefab;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStagePrefab extends Prefab {
    private final List<WidgetPrefab> widgetPrefabs;
    private final StateBarPrefab stateBarPrefab;
    private final MessageBarPrefab messageBarPrefab;

    public HudStagePrefab(
            List<WidgetPrefab> widgetPrefabs,
            StateBarPrefab stateBarPrefab,
            MessageBarPrefab messageBarPrefab
    ) {
        this.widgetPrefabs = widgetPrefabs;
        this.stateBarPrefab = stateBarPrefab;
        this.messageBarPrefab = messageBarPrefab;
    }

    public List<WidgetPrefab> getWidgetPrefabs() {
        return widgetPrefabs;
    }

    public StateBarPrefab getStateBarPrefab() {
        return stateBarPrefab;
    }

    public MessageBarPrefab getMessageBarPrefab() {
        return messageBarPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("widgetPrefabs", widgetPrefabs)
                .add("stateBarPrefab", stateBarPrefab)
                .add("messageBarPrefab", messageBarPrefab)
                .toString();
    }
}
