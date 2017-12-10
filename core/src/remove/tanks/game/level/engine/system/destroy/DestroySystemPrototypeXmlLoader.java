package remove.tanks.game.level.engine.system.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class DestroySystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<DestroySystemPrototype>
{
    @Override
    public DestroySystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new DestroySystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.DestroySystem;
    }
}
