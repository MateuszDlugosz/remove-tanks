package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AutoShootComponentPrefab> {
    @Override
    public AutoShootComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return AutoShootComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.AutoShootComponent;
    }
}