package remove.tanks.game.level.engine.entity.component.lifetime;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<LifetimeComponentPrototype>
{
    private static final String LIFETIME_ELEMENT = "lifetime";

    @Override
    public LifetimeComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new LifetimeComponentPrototype(
                    loadLifetime(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private float loadLifetime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(LIFETIME_ELEMENT).getText().trim());
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.LifetimeComponent;
    }
}
