package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldUpdateSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<WorldUpdateSystemPrototype>
{
    @Override
    public WorldUpdateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new WorldUpdateSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WorldUpdateSystem;
    }
}
