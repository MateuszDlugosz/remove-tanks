package remove.tanks.game.level.engine.entity.component.health;

import com.badlogic.gdx.utils.XmlReader;
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
        return new HealthComponentPrototype(
                Integer.valueOf(element.getChildByName(HEALTH_ELEMENT).getText().trim()),
                Integer.valueOf(element.getChildByName(MAX_HEALTH_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.HealthComponent;
    }
}
