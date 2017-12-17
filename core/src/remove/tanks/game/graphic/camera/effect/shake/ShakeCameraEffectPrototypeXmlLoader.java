package remove.tanks.game.graphic.camera.effect.shake;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.camera.effect.CameraEffectType;
import remove.tanks.game.graphic.camera.effect.RegistrableCameraEffectPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ShakeCameraEffectPrototypeXmlLoader
        implements RegistrableCameraEffectPrototypeXmlLoader<ShakeCameraEffectPrototype>
{
    private static final String TIME_ELEMENT = "time";
    private static final String POWER_ELEMENT = "power";

    @Override
    public ShakeCameraEffectPrototype loadCameraEffect(XmlReader.Element element) {
        return new ShakeCameraEffectPrototype(
                loadTime(element),
                loadPower(element)
        );
    }

    private float loadTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private float loadPower(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(POWER_ELEMENT).getText().trim());
    }

    @Override
    public CameraEffectType getLoaderType() {
        return CameraEffectType.ShakeCameraEffect;
    }
}
