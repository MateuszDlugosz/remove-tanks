package remove.tanks.game.graphics.camera.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubCameraEffectPrefabXmlReader<T extends CameraEffectPrefab> {
    T readCameraEffectPrefab(XmlReader.Element element);
    CameraEffectType getReaderType();
}
