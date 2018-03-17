package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<CloudLayerRenderSystemPrefab> {
    @Override
    protected CloudLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new CloudLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.CloudLayerRenderSystem;
    }
}
