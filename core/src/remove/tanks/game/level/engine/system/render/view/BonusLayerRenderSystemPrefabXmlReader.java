package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<BonusLayerRenderSystemPrefab> {
    @Override
    protected BonusLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new BonusLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.BonusLayerRenderSystem;
    }
}
