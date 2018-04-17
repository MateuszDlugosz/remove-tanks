package remove.tanks.game.level.engine.system.render.map;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class FogOfWarMapLayerRenderSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<FogOfWarMapLayerRenderSystemPrefab> {
    @Override
    public FogOfWarMapLayerRenderSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new FogOfWarMapLayerRenderSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.FogOfWarMapLayerRenderSystem;
    }
}
