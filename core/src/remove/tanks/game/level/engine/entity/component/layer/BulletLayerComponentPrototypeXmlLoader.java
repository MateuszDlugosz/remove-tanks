package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BulletLayerComponentPrototype>
{
    @Override
    public BulletLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new BulletLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BulletLayerComponent;
    }
}
