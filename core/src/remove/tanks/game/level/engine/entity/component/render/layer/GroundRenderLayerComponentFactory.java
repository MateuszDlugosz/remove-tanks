package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class GroundRenderLayerComponentFactory implements SubComponentFactory<GroundRenderLayerComponent, GroundRenderLayerComponentPrefab> {
    @Override
    public GroundRenderLayerComponent createComponent(GroundRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return GroundRenderLayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<GroundRenderLayerComponentPrefab> getFactoryType() {
        return GroundRenderLayerComponentPrefab.class;
    }
}
