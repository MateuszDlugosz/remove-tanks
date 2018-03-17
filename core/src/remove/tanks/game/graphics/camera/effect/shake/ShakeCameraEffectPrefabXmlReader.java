package remove.tanks.game.graphics.camera.effect.shake;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReadException;
import remove.tanks.game.graphics.camera.effect.CameraEffectType;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectPrefabXmlReader implements SubCameraEffectPrefabXmlReader<ShakeCameraEffectPrefab> {
    private static final String TIME_ELEMENT = "time";
    private static final String POWER_ELEMENT = "power";

    @Override
    public ShakeCameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        try {
            return new ShakeCameraEffectPrefab(
                    readTime(element),
                    readPower(element)
            );
        } catch (Exception e) {
            throw new CameraEffectPrefabXmlReadException(element, e);
        }
    }

    private float readTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private float readPower(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(POWER_ELEMENT).getText().trim());
    }

    @Override
    public CameraEffectType getReaderType() {
        return CameraEffectType.ShakeCameraEffect;
    }
}