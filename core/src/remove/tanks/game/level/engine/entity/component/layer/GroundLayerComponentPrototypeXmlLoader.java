package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<GroundLayerComponentPrototype>
{
    @Override
    public GroundLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new GroundLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.GroundLayerComponent;
    }
}
