package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
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
        try {
            return new CameraEffectSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.CameraEffectSystem;
    }
}
