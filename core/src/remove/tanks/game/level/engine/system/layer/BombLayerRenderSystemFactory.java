package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerRenderSystemFactory
        extends LayerRenderSystemFactory<BombLayerRenderSystem, BombLayerRenderSystemPrototype>
{
    public BombLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<BombLayerRenderSystemPrototype> getFactoryType() {
        return BombLayerRenderSystemPrototype.class;
    }

    @Override
    protected BombLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new BombLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
