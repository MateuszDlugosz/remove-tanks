package remove.tanks.game.level.engine.system.render.map;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class GroundMapLayerRenderSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<GroundMapLayerRenderSystemPrefab> {
    @Override
    public GroundMapLayerRenderSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new GroundMapLayerRenderSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.GroundMapLayerRenderSystem;
    }
}
