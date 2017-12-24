package remove.tanks.game.level.engine.system.move;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
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
        try {
            return new AutoMoveSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.AutoMoveSystem;
    }
}
