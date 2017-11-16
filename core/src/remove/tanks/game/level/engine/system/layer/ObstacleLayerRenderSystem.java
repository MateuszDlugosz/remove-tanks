package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.level.engine.entity.EntityFamily;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystem extends LayerRenderSystem {
    public ObstacleLayerRenderSystem(ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect highlightEffect, int priority) {
        super(viewRenderer, spriteBatch, highlightEffect, EntityFamily.ObstacleLayerRenderableFamily.getFamily(), priority);
    }
}
