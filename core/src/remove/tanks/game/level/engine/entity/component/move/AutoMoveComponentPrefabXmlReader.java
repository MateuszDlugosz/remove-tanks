package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AutoMoveComponentPrefab> {
    @Override
    public AutoMoveComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new AutoMoveComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.AutoMoveComponent;
    }
}
