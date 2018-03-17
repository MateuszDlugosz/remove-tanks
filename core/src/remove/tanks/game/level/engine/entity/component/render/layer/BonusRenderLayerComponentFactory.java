package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class BonusRenderLayerComponentFactory implements SubComponentFactory<BonusRenderLayerComponent, BonusRenderLayerComponentPrefab> {
    @Override
    public BonusRenderLayerComponent createComponent(BonusRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new BonusRenderLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<BonusRenderLayerComponentPrefab> getFactoryType() {
        return BonusRenderLayerComponentPrefab.class;
    }
}
