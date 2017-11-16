package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<VehicleLayerComponentPrototype>
{
    @Override
    public VehicleLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new VehicleLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.VehicleLayerComponent;
    }
}
