package remove.tanks.game.level.event.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.camera.effect.CameraEffectPrototype;
import remove.tanks.game.graphic.camera.effect.CameraEffectPrototypeXmlLoader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<AddCameraEffectEventPrototype>
{
    private final CameraEffectPrototypeXmlLoader cameraEffectPrototypeXmlLoader;

    public AddCameraEffectEventPrototypeXmlLoader(
            CameraEffectPrototypeXmlLoader cameraEffectPrototypeXmlLoader
    ) {
        this.cameraEffectPrototypeXmlLoader = cameraEffectPrototypeXmlLoader;
    }

    @Override
    public AddCameraEffectEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new AddCameraEffectEventPrototype(
                loadCameraEffectPrototype(element)
        );
    }

    private CameraEffectPrototype loadCameraEffectPrototype(XmlReader.Element element) {
        return cameraEffectPrototypeXmlLoader.loadCameraEffectPrototype(
                element.getChildByName(CameraEffectPrototypeXmlLoader.CAMERA_EFFECT_ELEMENT)
        );
    }

    @Override
    public EventType getLoaderType() {
        return EventType.AddCameraEffectEvent;
    }
}
