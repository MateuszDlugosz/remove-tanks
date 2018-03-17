package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentPrefabXmlReader implements SubComponentPrefabXmlReader<LifetimeComponentPrefab> {
    private static final String LIFETIME_ELEMENT = "lifetime";

    @Override
    public LifetimeComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new LifetimeComponentPrefab(readLifetime(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readLifetime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(LIFETIME_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.LifetimeComponent;
    }
}
