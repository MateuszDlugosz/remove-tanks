package remove.tanks.game.level.engine.system.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<AutoMoveSystemPrototype>
{
    @Override
    protected AutoMoveSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new AutoMoveSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoMoveSystem;
    }
}
