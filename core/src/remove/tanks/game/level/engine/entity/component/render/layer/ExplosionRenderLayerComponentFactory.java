package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionRenderLayerComponentFactory implements SubComponentFactory<ExplosionRenderLayerComponent, ExplosionRenderLayerComponentPrefab> {
    @Override
    public ExplosionRenderLayerComponent createComponent(ExplosionRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ExplosionRenderLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<ExplosionRenderLayerComponentPrefab> getFactoryType() {
        return ExplosionRenderLayerComponentPrefab.class;
    }
}
