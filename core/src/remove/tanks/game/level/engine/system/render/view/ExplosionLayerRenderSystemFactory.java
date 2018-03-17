package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<ExplosionLayerRenderSystem, ExplosionLayerRenderSystemPrefab> {
    public ExplosionLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected ExplosionLayerRenderSystem createEntityLayerRenderSystem(ExplosionLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new ExplosionLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<ExplosionLayerRenderSystemPrefab> getFactoryType() {
        return ExplosionLayerRenderSystemPrefab.class;
    }
}
