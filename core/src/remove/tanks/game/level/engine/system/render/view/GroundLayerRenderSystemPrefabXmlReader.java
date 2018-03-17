package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<GroundLayerRenderSystemPrefab> {
    @Override
    protected GroundLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new GroundLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.GroundLayerRenderSystem;
    }
}
