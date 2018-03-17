package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<WorldUpdateSystemPrefab> {
    @Override
    public WorldUpdateSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new WorldUpdateSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.WorldUpdateSystem;
    }
}
