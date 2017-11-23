package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerRenderSystemFactory
        extends LayerRenderSystemFactory<BomberLayerRenderSystem, BomberLayerRenderSystemPrototype>
{
    public BomberLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<BomberLayerRenderSystemPrototype> getFactoryType() {
        return BomberLayerRenderSystemPrototype.class;
    }

    @Override
    protected BomberLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new BomberLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
