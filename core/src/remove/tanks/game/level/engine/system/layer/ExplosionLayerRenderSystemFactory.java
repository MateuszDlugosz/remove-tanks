package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerRenderSystemFactory
        extends LayerRenderSystemFactory<ExplosionLayerRenderSystem, ExplosionLayerRenderSystemPrototype>
{
    public ExplosionLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    public Class<ExplosionLayerRenderSystemPrototype> getFactoryType() {
        return ExplosionLayerRenderSystemPrototype.class;
    }

    @Override
    protected ExplosionLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new ExplosionLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
