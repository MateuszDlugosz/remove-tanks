package remove.tanks.game.level.engine.system.lifetime;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<LifetimeSystemPrototype>
{
    @Override
    protected LifetimeSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new LifetimeSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.LifetimeSystem;
    }
}
