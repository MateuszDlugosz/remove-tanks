package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerRenderSystemFactory
        extends LayerRenderSystemFactory<VehicleLayerRenderSystem, VehicleLayerRenderSystemPrototype>
{
    public VehicleLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<VehicleLayerRenderSystemPrototype> getFactoryType() {
        return VehicleLayerRenderSystemPrototype.class;
    }

    @Override
    protected VehicleLayerRenderSystem createEntitySystem(ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect, int priority) {
        return new VehicleLayerRenderSystem(viewRenderer, spriteBatch, effect, priority);
    }
}
