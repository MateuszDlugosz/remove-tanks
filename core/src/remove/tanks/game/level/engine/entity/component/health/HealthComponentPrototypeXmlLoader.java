package remove.tanks.game.level.engine.entity.component.health;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HealthComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<HealthComponentPrototype>
{
    private static final String HEALTH_ELEMENT = "health";
    private static final String MAX_HEALTH_ELEMENT = "maxHealth";

    @Override
    public HealthComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new HealthComponentPrototype(
                    loadHealth(element),
                    loadMaxHealth(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private int loadHealth(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(HEALTH_ELEMENT).getText().trim());
    }

    private int loadMaxHealth(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(MAX_HEALTH_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.HealthComponent;
    }
}
