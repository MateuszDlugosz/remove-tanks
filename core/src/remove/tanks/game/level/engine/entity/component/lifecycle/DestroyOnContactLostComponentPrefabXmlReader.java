package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactLostComponentPrefabXmlReader implements SubComponentPrefabXmlReader<DestroyOnContactLostComponentPrefab> {
    @Override
    public DestroyOnContactLostComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return DestroyOnContactLostComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DestroyOnContactLostComponent;
    }
}
