package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<PlayerComponentPrefab> {
    @Override
    public PlayerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new PlayerComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.PlayerComponent;
    }
}
