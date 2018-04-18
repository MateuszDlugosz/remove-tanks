package remove.tanks.game.level.engine.entity.component.cloud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class CloudComponentPrefabXmlReader implements SubComponentPrefabXmlReader<CloudComponentPrefab> {
    @Override
    public CloudComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return CloudComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.CloudComponent;
    }
}
