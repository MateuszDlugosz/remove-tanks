package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

public final class DestroyOnContactComponentPrefabXmlReader implements SubComponentPrefabXmlReader<DestroyOnContactComponentPrefab> {
    @Override
    public DestroyOnContactComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new DestroyOnContactComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.DestroyOnContactComponent;
    }
}
