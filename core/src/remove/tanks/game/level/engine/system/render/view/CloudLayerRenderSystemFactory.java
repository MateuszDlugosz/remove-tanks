package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<CloudLayerRenderSystem, CloudLayerRenderSystemPrefab> {
    public CloudLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected CloudLayerRenderSystem createEntityLayerRenderSystem(CloudLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new CloudLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<CloudLayerRenderSystemPrefab> getFactoryType() {
        return CloudLayerRenderSystemPrefab.class;
    }
}
