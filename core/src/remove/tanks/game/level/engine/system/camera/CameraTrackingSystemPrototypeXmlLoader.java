package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackingSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<CameraTrackingSystemPrototype>
{
    @Override
    protected CameraTrackingSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new CameraTrackingSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CameraTrackingSystem;
    }
}
