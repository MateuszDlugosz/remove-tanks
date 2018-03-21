package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RespawnComponentPrefabXmlReader implements SubComponentPrefabXmlReader<RespawnComponentPrefab> {
    @Override
    public RespawnComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return RespawnComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.RespawnComponent;
    }
}
