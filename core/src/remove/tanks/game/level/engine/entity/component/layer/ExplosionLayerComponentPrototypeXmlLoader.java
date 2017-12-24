package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<ExplosionLayerComponentPrototype>
{
    @Override
    public ExplosionLayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new ExplosionLayerComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ExplosionLayerComponent;
    }
}
