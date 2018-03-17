package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<ObstacleLayerRenderSystemPrefab> {
    @Override
    protected ObstacleLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new ObstacleLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.ObstacleLayerRenderSystem;
    }
}
