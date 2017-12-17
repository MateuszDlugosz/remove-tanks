package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<CameraEffectSystemPrototype>
{
    @Override
    public CameraEffectSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new CameraEffectSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CameraEffectSystem;
    }
}
