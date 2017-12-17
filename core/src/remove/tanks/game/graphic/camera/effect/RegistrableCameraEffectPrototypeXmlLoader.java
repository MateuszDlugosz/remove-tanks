package remove.tanks.game.graphic.camera.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableCameraEffectPrototypeXmlLoader<T extends CameraEffectPrototype> {
    T loadCameraEffect(XmlReader.Element element);
    CameraEffectType getLoaderType();
}
