package remove.tanks.game.level.event.state;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<ChangeLevelStateEventPrototype>
{
    private static final String LEVEL_STATE_ELEMENT = "levelState";

    @Override
    public ChangeLevelStateEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new ChangeLevelStateEventPrototype(
                    loadLevelState(element)
            );
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    private LevelState loadLevelState(XmlReader.Element element) {
        return LevelState.valueOf(element.getChildByName(LEVEL_STATE_ELEMENT).getText().trim());
    }

    @Override
    public EventType getLoaderType() {
        return EventType.ChangeLevelStateEvent;
    }
}
