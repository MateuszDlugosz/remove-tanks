package remove.tanks.game.level.engine.system.control;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<PlayerControlSystemPrototype>
{
    @Override
    public PlayerControlSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new PlayerControlSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.PlayerControlSystem;
    }
}
