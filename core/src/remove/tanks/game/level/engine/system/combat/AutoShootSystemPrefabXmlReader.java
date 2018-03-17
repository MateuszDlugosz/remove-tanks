package remove.tanks.game.level.engine.system.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<AutoShootSystemPrefab> {
    @Override
    public AutoShootSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new AutoShootSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.AutoShootSystem;
    }
}
