package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<BombLayerRenderSystemPrefab> {
    @Override
    protected BombLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new BombLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.BombLayerRenderSystem;
    }
}
