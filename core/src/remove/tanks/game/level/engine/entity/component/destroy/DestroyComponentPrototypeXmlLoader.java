package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<DestroyComponentPrototype>
{
    @Override
    public DestroyComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new DestroyComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.DestroyComponent;
    }
}
