package remove.tanks.game.graphics.camera.effect.rotate;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReadException;
import remove.tanks.game.graphics.camera.effect.CameraEffectType;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ContinuousRotateCameraEffectPrefabXmlReader implements SubCameraEffectPrefabXmlReader<ContinuousRotateCameraEffectPrefab> {
    private static final String ROTATION_SPEED_ELEMENT = "rotationSpeed";

    @Override
    public ContinuousRotateCameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        try {
            return new ContinuousRotateCameraEffectPrefab(readRotationSpeed(element));
        } catch (Exception e) {
            throw new CameraEffectPrefabXmlReadException(element, e);
        }
    }

    private float readRotationSpeed(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(ROTATION_SPEED_ELEMENT).getText().trim());
    }

    @Override
    public CameraEffectType getReaderType() {
        return CameraEffectType.ContinuousRotationCameraEffect;
    }
}
