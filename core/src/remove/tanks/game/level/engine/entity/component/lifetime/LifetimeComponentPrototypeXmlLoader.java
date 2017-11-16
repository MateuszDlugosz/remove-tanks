package remove.tanks.game.level.engine.entity.component.lifetime;

import com.badlogic.gdx.utils.XmlReader;
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
        return new LifetimeComponentPrototype(
                Float.valueOf(element.getChildByName(LIFETIME_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.LifetimeComponent;
    }
}
