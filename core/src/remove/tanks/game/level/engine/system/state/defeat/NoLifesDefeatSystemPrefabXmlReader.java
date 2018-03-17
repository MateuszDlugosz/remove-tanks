package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class NoLifesDefeatSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<NoLifesDefeatSystemPrefab> {
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public NoLifesDefeatSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new NoLifesDefeatSystemPrefab(priority, readDelay(element));
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private float readDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.NoLifesDefeatSystem;
    }
}
