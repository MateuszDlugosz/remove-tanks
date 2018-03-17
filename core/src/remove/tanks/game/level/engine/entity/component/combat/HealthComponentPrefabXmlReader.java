package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentPrefabXmlReader implements SubComponentPrefabXmlReader<HealthComponentPrefab> {
    private static final String MAX_HEALTH_ELEMENT = "maxHealth";
    private static final String HEALTH_ELEMENT = "health";

    @Override
    public HealthComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new HealthComponentPrefab(
                    readMaxHealth(element),
                    readHealth(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private int readMaxHealth(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(MAX_HEALTH_ELEMENT).getText().trim());
    }

    private int readHealth(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(HEALTH_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.HealthComponent;
    }
}
