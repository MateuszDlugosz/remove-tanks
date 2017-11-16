package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<DestroyOnContactComponentPrototype>
{
    @Override
    public DestroyOnContactComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new DestroyOnContactComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.DestroyOnContactComponent;
    }
}
