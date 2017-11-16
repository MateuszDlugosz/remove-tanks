package remove.tanks.game.level.engine.system.control;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<PlayerControlSystemPrototype>
{
    @Override
    protected PlayerControlSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new PlayerControlSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.PlayerControlSystem;
    }
}
