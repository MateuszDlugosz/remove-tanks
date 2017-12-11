package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<CameraTrackSystemPrototype>
{
    @Override
    public CameraTrackSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new CameraTrackSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CameraTrackSystem;
    }
}
