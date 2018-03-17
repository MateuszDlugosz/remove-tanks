package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystemFactory extends AbstractLayerRenderSystemFactory<ObstacleLayerRenderSystem, ObstacleLayerRenderSystemPrefab> {
    public ObstacleLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    protected ObstacleLayerRenderSystem createEntityLayerRenderSystem(ObstacleLayerRenderSystemPrefab prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        return new ObstacleLayerRenderSystem(prefab.getPriority(), viewRenderer, spriteBatch);
    }

    @Override
    public Class<ObstacleLayerRenderSystemPrefab> getFactoryType() {
        return ObstacleLayerRenderSystemPrefab.class;
    }
}
