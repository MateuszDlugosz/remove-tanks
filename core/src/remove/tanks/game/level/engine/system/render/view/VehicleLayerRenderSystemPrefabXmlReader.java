package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemPrefabXmlReader extends AbstractLayerRenderSystemPrefabXmlReader<VehicleLayerRenderSystemPrefab> {
    @Override
    protected VehicleLayerRenderSystemPrefab readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority) {
        return new VehicleLayerRenderSystemPrefab(priority);
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.VehicleLayerRenderSystem;
    }
}
