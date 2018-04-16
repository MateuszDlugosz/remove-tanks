package remove.tanks.game.level.engine.system.state.reset;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.system.state.defeat.NoLifesDefeatSystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class PlayerDestroyedResetSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<PlayerDestroyedResetSystemPrefab> {
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public PlayerDestroyedResetSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new PlayerDestroyedResetSystemPrefab(priority, readDelay(element));
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private float readDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.PlayerDestroyedResetSystem;
    }
}
