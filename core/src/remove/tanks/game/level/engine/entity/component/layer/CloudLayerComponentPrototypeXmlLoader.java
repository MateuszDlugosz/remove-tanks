package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<CloudLayerComponentPrototype>
{
    @Override
    public CloudLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new CloudLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.CloudLayerComponent;
    }
}
