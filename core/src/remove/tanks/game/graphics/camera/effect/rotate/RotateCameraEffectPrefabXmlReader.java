package remove.tanks.game.graphics.camera.effect.rotate;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReadException;
import remove.tanks.game.graphics.camera.effect.CameraEffectType;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RotateCameraEffectPrefabXmlReader implements SubCameraEffectPrefabXmlReader<RotateCameraEffectPrefab> {
    private static final String ROTATION_SPEED_ELEMENT = "rotationSpeed";
    private static final String NUMBER_OF_ROTATIONS_ELEMENT = "numberOfRotations";
    private static final String CLOCKWISE_DIRECTION_ELEMENT = "clockwiseDirection";

    @Override
    public RotateCameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        try {
            return new RotateCameraEffectPrefab(
                    readRotationSpeed(element),
                    readNumberOfRotations(element),
                    readClockwiseDirection(element)
            );
        } catch (Exception e) {
            throw new CameraEffectPrefabXmlReadException(element, e);
        }
    }

    private float readRotationSpeed(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(ROTATION_SPEED_ELEMENT).getText().trim());
    }

    private int readNumberOfRotations(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(NUMBER_OF_ROTATIONS_ELEMENT).getText().trim());
    }

    private boolean readClockwiseDirection(XmlReader.Element element) {
        return Boolean.valueOf(element.getChildByName(CLOCKWISE_DIRECTION_ELEMENT).getText().trim());
    }

    @Override
    public CameraEffectType getReaderType() {
        return CameraEffectType.RotateCameraEffect;
    }
}
