package remove.tanks.game.level.engine.system.shoot;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<AutoShootSystemPrototype>
{
    @Override
    public AutoShootSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new AutoShootSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoShootSystem;
    }
}
