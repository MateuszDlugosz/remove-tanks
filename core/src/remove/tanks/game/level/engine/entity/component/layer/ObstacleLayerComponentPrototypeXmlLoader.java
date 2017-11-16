package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ObstacleLayerComponentPrototype>
{
    @Override
    public ObstacleLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new ObstacleLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ObstacleLayerComponent;
    }
}
