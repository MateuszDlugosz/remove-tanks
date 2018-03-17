package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentPrefabXmlReader implements SubComponentPrefabXmlReader<DestroyComponentPrefab> {
    @Override
    public DestroyComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new DestroyComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DestroyComponent;
    }
}
