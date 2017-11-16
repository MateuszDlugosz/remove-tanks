package remove.tanks.game.level.engine.system.actor;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControlSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<ActorDirectionControlSystemPrototype>
{
    @Override
    protected ActorDirectionControlSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new ActorDirectionControlSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ActorDirectionControlSystem;
    }
}
