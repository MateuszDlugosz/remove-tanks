package remove.tanks.game.level.engine.entity.component.airplane;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AirplaneComponentPrefab> {
    @Override
    public AirplaneComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return AirplaneComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.AirplaneComponent;
    }
}
