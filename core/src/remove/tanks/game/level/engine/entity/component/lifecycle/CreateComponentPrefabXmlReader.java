package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class CreateComponentPrefabXmlReader implements SubComponentPrefabXmlReader<CreateComponentPrefab> {
    @Override
    public CreateComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new CreateComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.CreateComponent;
    }
}
