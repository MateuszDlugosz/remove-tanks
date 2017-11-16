package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<CameraUpdateSystemPrototype>
{
    @Override
    protected CameraUpdateSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new CameraUpdateSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CameraUpdateSystem;
    }
}
