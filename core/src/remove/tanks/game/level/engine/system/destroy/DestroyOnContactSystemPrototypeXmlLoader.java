package remove.tanks.game.level.engine.system.destroy;

import com.badlogic.gdx.utils.XmlReader;
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
        return new DestroyOnContactSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.DestroyOnContactSystem;
    }
}
