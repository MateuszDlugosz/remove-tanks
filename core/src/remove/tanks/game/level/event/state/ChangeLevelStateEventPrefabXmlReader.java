package remove.tanks.game.level.event.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventPrefabXmlReader implements SubEventPrefabXmlReader<ChangeLevelStateEventPrefab> {
    private static final String LEVEL_STATE_ELEMENT = "levelState";

    @Override
    public ChangeLevelStateEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new ChangeLevelStateEventPrefab(readLevelState(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private LevelState readLevelState(XmlReader.Element element) {
        return LevelState.valueOf(element.getChildByName(LEVEL_STATE_ELEMENT).getText().trim());
    }

    @Override
    public EventType getReaderType() {
        return EventType.ChangeLevelStateEvent;
    }
}
