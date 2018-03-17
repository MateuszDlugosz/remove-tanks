package remove.tanks.game.level.engine.system.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<RandomDirectionSystemPrefab> {
    @Override
    public RandomDirectionSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new RandomDirectionSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.RandomDirectionSystem;
    }
}
