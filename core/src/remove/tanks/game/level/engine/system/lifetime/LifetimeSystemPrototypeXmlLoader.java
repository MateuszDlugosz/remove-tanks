package remove.tanks.game.level.engine.system.lifetime;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<LifetimeSystemPrototype>
{
    @Override
    public LifetimeSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new LifetimeSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.LifetimeSystem;
    }
}
