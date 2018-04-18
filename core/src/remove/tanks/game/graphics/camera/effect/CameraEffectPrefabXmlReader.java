package remove.tanks.game.graphics.camera.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class CameraEffectPrefabXmlReader {
    public static final String CAMERA_EFFECT_ELEMENT = "cameraEffect";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<CameraEffectType, SubCameraEffectPrefabXmlReader> readers
            = new EnumMap<>(CameraEffectType.class);

    public CameraEffectPrefabXmlReader(SubCameraEffectPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public CameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        try {
            CameraEffectType type = CameraEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new CameraEffectPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readCameraEffectPrefab(element);
        } catch (Exception e) {
            throw new CameraEffectPrefabXmlReadException(element, e);
        }
    }
}
