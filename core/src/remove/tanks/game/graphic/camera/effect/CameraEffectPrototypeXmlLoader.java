package remove.tanks.game.graphic.camera.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectPrototypeXmlLoader {
    public static final String CAMERA_EFFECT_ELEMENT = "cameraEffect";
    public static final String CAMERA_EFFECTS_ELEMENT = "cameraEffects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<CameraEffectType, RegistrableCameraEffectPrototypeXmlLoader> loaders
            = new HashMap<>();

    public CameraEffectPrototypeXmlLoader(RegistrableCameraEffectPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(l -> this.loaders.put(l.getLoaderType(), l));
    }

    public CameraEffectPrototype loadCameraEffectPrototype(XmlReader.Element element) {
        try {
            CameraEffectType type = CameraEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!loaders.containsKey(type)) {
                throw new CameraEffectPrototypeLoaderNotFoundException(type);
            }
            return loaders.get(type).loadCameraEffect(element);
        } catch (Exception e) {
            throw new CameraEffectPrototypeXmlLoadException(element, e);
        }
    }
}
