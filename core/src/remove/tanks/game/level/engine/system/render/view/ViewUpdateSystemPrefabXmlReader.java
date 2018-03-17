package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<ViewUpdateSystemPrefab> {
    @Override
    public ViewUpdateSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new ViewUpdateSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.ViewUpdateSystem;
    }
}
