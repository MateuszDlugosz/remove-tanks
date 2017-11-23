package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerRenderSystemFactory
        extends LayerRenderSystemFactory<GroundLayerRenderSystem, GroundLayerRenderSystemPrototype>
{
    public GroundLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<GroundLayerRenderSystemPrototype> getFactoryType() {
        return GroundLayerRenderSystemPrototype.class;
    }

    @Override
    protected GroundLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new GroundLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
