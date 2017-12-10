package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemPrototypeXmlLoader<T extends LayerRenderSystemPrototype>
        extends RegistrableEntitySystemPrototypeXmlLoader<T>
{
    @Override
    protected final T loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return loadEntitySystemPrototype(priority);
    }

    protected abstract T loadEntitySystemPrototype(int priority);
}
