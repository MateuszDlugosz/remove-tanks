package remove.tanks.game.level.utility.stage;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.utility.stage.broker.MessageBarPrefab;
import remove.tanks.game.level.utility.stage.broker.MessageBarPrefabXmlReader;
import remove.tanks.game.level.utility.stage.state.StateBarPrefab;
import remove.tanks.game.level.utility.stage.state.StateBarPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefab;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStagePrefabXmlReader {
    public static final String STAGE_ELEMENT = "stage";

    private final WidgetPrefabXmlReader widgetPrefabXmlReader;
    private final StateBarPrefabXmlReader stateBarPrefabXmlReader;
    private final MessageBarPrefabXmlReader messageBarPrefabXmlReader;

    public HudStagePrefabXmlReader(
            WidgetPrefabXmlReader widgetPrefabXmlReader,
            StateBarPrefabXmlReader stateBarPrefabXmlReader,
            MessageBarPrefabXmlReader messageBarPrefabXmlReader
    ) {
        this.widgetPrefabXmlReader = widgetPrefabXmlReader;
        this.stateBarPrefabXmlReader = stateBarPrefabXmlReader;
        this.messageBarPrefabXmlReader = messageBarPrefabXmlReader;
    }

    public HudStagePrefab readHudStagePrefab(XmlReader.Element element) {
        try {
            return new HudStagePrefab(
                    readWidgetPrefabs(element),
                    readStateBarPrefab(element),
                    readMessageBarPrefab(element)
            );
        } catch (Exception e) {
            throw new HudStagePrefabXmlReadException(element, e);
        }
    }

    private List<WidgetPrefab> readWidgetPrefabs(XmlReader.Element element) {
        return widgetPrefabXmlReader.readWidgetPrefabs(
                element.getChildByName(WidgetPrefabXmlReader.WIDGETS_ELEMENT)
        );
    }

    private StateBarPrefab readStateBarPrefab(XmlReader.Element element) {
        return stateBarPrefabXmlReader.readStateBarPrefab(
                element.getChildByName(StateBarPrefabXmlReader.STATE_BAR_ELEMENT)
        );
    }

    private MessageBarPrefab readMessageBarPrefab(XmlReader.Element element) {
        return messageBarPrefabXmlReader.readMessageBarPrefab(
                element.getChildByName(MessageBarPrefabXmlReader.MESSAGE_BAR_ELEMENT)
        );
    }
}
