package remove.tanks.game.level.engine.system.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<AutoMoveSystemPrefab> {
    @Override
    public AutoMoveSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new AutoMoveSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.AutoMoveSystem;
    }
}
