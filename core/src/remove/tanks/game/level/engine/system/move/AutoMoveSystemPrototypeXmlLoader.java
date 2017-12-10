package remove.tanks.game.level.engine.system.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<AutoMoveSystemPrototype>
{
    @Override
    public AutoMoveSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new AutoMoveSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoMoveSystem;
    }
}
