package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<AirplaneLayerRenderSystemPrefab> {
    @Override
    protected AirplaneLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new AirplaneLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.AirplaneLayerRenderSystem;
    }
}
