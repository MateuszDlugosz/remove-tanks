package remove.tanks.game.level.engine.system.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<ViewUpdateSystemPrototype>
{
    @Override
    public ViewUpdateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new ViewUpdateSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ViewUpdateSystem;
    }
}
