package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.level.engine.entity.EntityFamily;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystem extends LayerRenderSystem {
    public BulletLayerRenderSystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect highlightEffect) {
        super(EntityFamily.BulletLayerRenderableFamily.getFamily(), priority, viewRenderer, spriteBatch, highlightEffect);
    }
}
