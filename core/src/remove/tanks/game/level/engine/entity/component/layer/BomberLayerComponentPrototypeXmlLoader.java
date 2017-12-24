package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BomberLayerComponentPrototype>
{
    @Override
    public BomberLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new BomberLayerComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BomberLayerComponent;
    }
}
