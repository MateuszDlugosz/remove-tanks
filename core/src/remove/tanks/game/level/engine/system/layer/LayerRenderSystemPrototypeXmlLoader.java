package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemPrototypeXmlLoader<T extends LayerRenderSystemPrototype>
        implements RegistrableEntitySystemPrototypeXmlLoader<T>
{
    @Override
    public final T loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return loadEntitySystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    protected abstract T loadEntitySystemPrototype(int priority);
}
