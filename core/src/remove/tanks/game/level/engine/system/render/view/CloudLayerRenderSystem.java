package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystem extends AbstractLayerRenderSystem {
    public CloudLayerRenderSystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch) {
        super(RenderLayerEntityFamily.CloudRenderLayerEntityFamily, priority, viewRenderer, spriteBatch);
    }
}
