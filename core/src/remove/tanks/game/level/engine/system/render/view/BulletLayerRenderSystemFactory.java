package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<BulletLayerRenderSystem, BulletLayerRenderSystemPrefab> {
    public BulletLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected BulletLayerRenderSystem createEntityLayerRenderSystem(BulletLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new BulletLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<BulletLayerRenderSystemPrefab> getFactoryType() {
        return BulletLayerRenderSystemPrefab.class;
    }
}
