package remove.tanks.game.level.engine.system.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdateSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<ViewUpdateSystemPrototype>
{
    @Override
    protected ViewUpdateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new ViewUpdateSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ViewUpdateSystem;
    }
}
