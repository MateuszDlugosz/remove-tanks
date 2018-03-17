package remove.tanks.game.level.event.entity.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefab;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

public final class AddCameraEffectEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AddCameraEffectEntityEventPrefab> {
    private final CameraEffectPrefabXmlReader cameraEffectPrefabXmlReader;

    public AddCameraEffectEntityEventPrefabXmlReader(CameraEffectPrefabXmlReader cameraEffectPrefabXmlReader) {
        this.cameraEffectPrefabXmlReader = cameraEffectPrefabXmlReader;
    }

    @Override
    public AddCameraEffectEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AddCameraEffectEntityEventPrefab(readCameraEffectPrefab(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private CameraEffectPrefab readCameraEffectPrefab(XmlReader.Element element) {
        return cameraEffectPrefabXmlReader.readCameraEffectPrefab(
                element.getChildByName(CameraEffectPrefabXmlReader.CAMERA_EFFECT_ELEMENT));
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AddCameraEffectEntityEvent;
    }
}
