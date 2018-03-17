package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<BonusLayerRenderSystem, BonusLayerRenderSystemPrefab> {
    public BonusLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected BonusLayerRenderSystem createEntityLayerRenderSystem(BonusLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new BonusLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<BonusLayerRenderSystemPrefab> getFactoryType() {
        return BonusLayerRenderSystemPrefab.class;
    }
}
