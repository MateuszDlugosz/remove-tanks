package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class BulletRenderLayerComponentFactory implements SubComponentFactory<BulletRenderLayerComponent, BulletRenderLayerComponentPrefab> {
    @Override
    public BulletRenderLayerComponent createComponent(BulletRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return BulletRenderLayerComponent.INSTANCE;
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<BulletRenderLayerComponentPrefab> getFactoryType() {
        return BulletRenderLayerComponentPrefab.class;
    }
}
