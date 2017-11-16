package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<AutoShootComponentPrototype>
{
    @Override
    public AutoShootComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new AutoShootComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.AutoShootComponent;
    }
}
