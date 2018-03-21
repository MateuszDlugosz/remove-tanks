package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class CloudRenderLayerComponentFactory implements SubComponentFactory<CloudRenderLayerComponent, CloudRenderLayerComponentPrefab> {
    @Override
    public CloudRenderLayerComponent createComponent(CloudRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return CloudRenderLayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<CloudRenderLayerComponentPrefab> getFactoryType() {
        return CloudRenderLayerComponentPrefab.class;
    }
}
