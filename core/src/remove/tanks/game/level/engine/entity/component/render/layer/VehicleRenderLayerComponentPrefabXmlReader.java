package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class VehicleRenderLayerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<VehicleRenderLayerComponentPrefab> {
    @Override
    public VehicleRenderLayerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return VehicleRenderLayerComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.VehicleRenderLayerComponent;
    }
}
