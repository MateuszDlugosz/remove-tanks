package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.*;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentPrefabXmlReader implements SubComponentPrefabXmlReader<ChangeBehaviorComponentPrefab> {
    private final ComponentPrefabXmlReader componentPrefabXmlReader;

    public ChangeBehaviorComponentPrefabXmlReader(ComponentPrefabXmlReader componentPrefabXmlReader) {
        this.componentPrefabXmlReader = componentPrefabXmlReader;
    }

    @Override
    public ChangeBehaviorComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new ChangeBehaviorComponentPrefab(readComponentPrefabs(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private List<ComponentPrefab> readComponentPrefabs(XmlReader.Element element) {
        return componentPrefabXmlReader.readComponentsPrefabs(element.getChildByName(ComponentPrefabXmlReader.COMPONENTS_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.ChangeBehaviorComponent;
    }
}
