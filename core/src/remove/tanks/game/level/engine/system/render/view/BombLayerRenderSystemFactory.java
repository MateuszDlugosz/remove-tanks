package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<BombLayerRenderSystem, BombLayerRenderSystemPrefab> {
    public BombLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected BombLayerRenderSystem createEntityLayerRenderSystem(BombLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new BombLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<BombLayerRenderSystemPrefab> getFactoryType() {
        return BombLayerRenderSystemPrefab.class;
    }
}
