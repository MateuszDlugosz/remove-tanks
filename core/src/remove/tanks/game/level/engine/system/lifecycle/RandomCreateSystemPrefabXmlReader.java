package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<RandomCreateSystemPrefab> {
    @Override
    public RandomCreateSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new RandomCreateSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.RandomCreateSystem;
    }
}
