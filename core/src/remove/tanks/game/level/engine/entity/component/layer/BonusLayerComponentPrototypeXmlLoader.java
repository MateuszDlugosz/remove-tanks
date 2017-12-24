package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BonusLayerComponentPrototype>
{
    @Override
    public BonusLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new BonusLayerComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BonusLayerComponent;
    }
}
