package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneRenderLayerComponentFactory implements SubComponentFactory<AirplaneRenderLayerComponent, AirplaneRenderLayerComponentPrefab> {
    @Override
    public AirplaneRenderLayerComponent createComponent(AirplaneRenderLayerComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new AirplaneRenderLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    @Override
    public Class<AirplaneRenderLayerComponentPrefab> getFactoryType() {
        return AirplaneRenderLayerComponentPrefab.class;
    }
}
