package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<GroundLayerRenderSystem, GroundLayerRenderSystemPrefab> {
    public GroundLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected GroundLayerRenderSystem createEntityLayerRenderSystem(GroundLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new GroundLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<GroundLayerRenderSystemPrefab> getFactoryType() {
        return GroundLayerRenderSystemPrefab.class;
    }
}
