package remove.tanks.game.level.engine.system.camera;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<CameraTrackSystemPrefab> {
    @Override
    public CameraTrackSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new CameraTrackSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.CameraTrackSystem;
    }
}
