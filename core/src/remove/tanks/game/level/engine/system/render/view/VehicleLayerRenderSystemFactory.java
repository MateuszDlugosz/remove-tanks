package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<VehicleLayerRenderSystem, VehicleLayerRenderSystemPrefab> {
    public VehicleLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected VehicleLayerRenderSystem createEntityLayerRenderSystem(VehicleLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new VehicleLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<VehicleLayerRenderSystemPrefab> getFactoryType() {
        return VehicleLayerRenderSystemPrefab.class;
    }
}
