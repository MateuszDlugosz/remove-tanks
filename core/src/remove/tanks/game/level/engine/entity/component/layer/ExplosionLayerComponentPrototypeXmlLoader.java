package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.gdx.utils.XmlReader;
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
        return new ExplosionLayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.ExplosionLayerComponent;
    }
}
