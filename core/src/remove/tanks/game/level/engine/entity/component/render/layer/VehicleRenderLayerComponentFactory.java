package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class VehicleRenderLayerComponentFactory implements SubComponentFactory<VehicleRenderLayerComponent, VehicleRenderLayerComponentPrefab> {
    @Override
    public VehicleRenderLayerComponent createComponent(VehicleRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return VehicleRenderLayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<VehicleRenderLayerComponentPrefab> getFactoryType() {
        return VehicleRenderLayerComponentPrefab.class;
    }
}
