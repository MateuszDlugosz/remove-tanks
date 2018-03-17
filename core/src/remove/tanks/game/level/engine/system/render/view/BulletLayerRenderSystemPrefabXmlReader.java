package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<BulletLayerRenderSystemPrefab> {
    @Override
    protected BulletLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new BulletLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.BulletLayerRenderSystem;
    }
}
