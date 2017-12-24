package remove.tanks.game.level.engine.system.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<DestroyOnContactSystemPrototype>
{
    @Override
    public DestroyOnContactSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new DestroyOnContactSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.DestroyOnContactSystem;
    }
}
