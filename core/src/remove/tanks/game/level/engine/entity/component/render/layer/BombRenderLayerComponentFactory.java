package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class BombRenderLayerComponentFactory implements SubComponentFactory<BombRenderLayerComponent, BombRenderLayerComponentPrefab> {
    @Override
    public BombRenderLayerComponent createComponent(BombRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return BombRenderLayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<BombRenderLayerComponentPrefab> getFactoryType() {
        return BombRenderLayerComponentPrefab.class;
    }
}
