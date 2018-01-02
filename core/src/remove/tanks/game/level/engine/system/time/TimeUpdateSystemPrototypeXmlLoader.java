package remove.tanks.game.level.engine.system.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TimeUpdateSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<TimeUpdateSystemPrototype>
{
    @Override
    public TimeUpdateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new TimeUpdateSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.TimeUpdateSystem;
    }
}
