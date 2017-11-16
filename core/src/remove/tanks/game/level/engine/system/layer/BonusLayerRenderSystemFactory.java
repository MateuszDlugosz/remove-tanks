package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerRenderSystemFactory
        extends LayerRenderSystemFactory<BonusLayerRenderSystem, BonusLayerRenderSystemPrototype>
{
    public BonusLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<BonusLayerRenderSystemPrototype> getFactoryType() {
        return BonusLayerRenderSystemPrototype.class;
    }

    @Override
    protected BonusLayerRenderSystem createEntitySystem(ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect, int priority) {
        return new BonusLayerRenderSystem(viewRenderer, spriteBatch, effect, priority);
    }
}
