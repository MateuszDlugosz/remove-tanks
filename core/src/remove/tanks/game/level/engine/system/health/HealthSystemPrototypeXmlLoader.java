package remove.tanks.game.level.engine.system.health;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class HealthSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<HealthSystemPrototype>
{
    @Override
    public HealthSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new HealthSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.HealthSystem;
    }
}
