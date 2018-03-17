package remove.tanks.game.level.event.entity.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<ChangeLevelStateEntityEventPrefab> {
    private static final String LEVEL_STATE_ELEMENT = "levelState";

    @Override
    public ChangeLevelStateEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new ChangeLevelStateEntityEventPrefab(readLevelState(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private LevelState readLevelState(XmlReader.Element element) {
        return LevelState.valueOf(element.getChildByName(LEVEL_STATE_ELEMENT).getText().trim());
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.ChangeLevelStateEntityEvent;
    }
}
