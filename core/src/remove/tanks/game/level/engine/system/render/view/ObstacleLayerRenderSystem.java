package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystem extends AbstractLayerRenderSystem {
    public ObstacleLayerRenderSystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        super(RenderLayerEntityFamily.ObstacleRenderLayerEntityFamily, priority, viewRenderer, spriteBatch);
    }
}
