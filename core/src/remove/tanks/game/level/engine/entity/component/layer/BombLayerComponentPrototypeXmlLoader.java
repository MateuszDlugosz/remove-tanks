package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BombLayerComponentPrototype>
{
    @Override
    public BombLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new BombLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BombLayerComponent;
    }
}
