package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<AirplaneLayerRenderSystem, AirplaneLayerRenderSystemPrefab> {
    public AirplaneLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected AirplaneLayerRenderSystem createEntityLayerRenderSystem(AirplaneLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new AirplaneLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<AirplaneLayerRenderSystemPrefab> getFactoryType() {
        return AirplaneLayerRenderSystemPrefab.class;
    }
}
