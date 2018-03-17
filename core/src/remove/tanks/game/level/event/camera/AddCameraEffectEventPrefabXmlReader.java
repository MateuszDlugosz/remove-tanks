package remove.tanks.game.level.event.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventPrefabXmlReader implements SubEventPrefabXmlReader<AddCameraEffectEventPrefab> {
    private final CameraEffectPrefabXmlReader cameraEffectPrefabXmlReader;

    public AddCameraEffectEventPrefabXmlReader(CameraEffectPrefabXmlReader cameraEffectPrefabXmlReader) {
        this.cameraEffectPrefabXmlReader = cameraEffectPrefabXmlReader;
    }

    @Override
    public AddCameraEffectEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new AddCameraEffectEventPrefab(readCameraEffectPrefab(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private CameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        return cameraEffectPrefabXmlReader.readCameraEffectPrefab(
                element.getChildByName(CameraEffectPrefabXmlReader.CAMERA_EFFECT_ELEMENT));
    }

    @Override
    public EventType getReaderType() {
        return EventType.AddCameraEffectEvent;
    }
}
