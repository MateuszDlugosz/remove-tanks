package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleRenderLayerComponentFactory implements SubComponentFactory<ObstacleRenderLayerComponent, ObstacleRenderLayerComponentPrefab> {
    @Override
    public ObstacleRenderLayerComponent createComponent(ObstacleRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
             return new ObstacleRenderLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<ObstacleRenderLayerComponentPrefab> getFactoryType() {
        return ObstacleRenderLayerComponentPrefab.class;
    }
}
