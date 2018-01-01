package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TimeEndDefeatSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<TimeEndDefeatSystemPrototype>
{
    @Override
    public TimeEndDefeatSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new TimeEndDefeatSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.TimeEndDefeatSystem;
    }
}
