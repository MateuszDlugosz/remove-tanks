package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<ExplosionLayerRenderSystemPrefab> {
    @Override
    protected ExplosionLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new ExplosionLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.ExplosionLayerRenderSystem;
    }
}
