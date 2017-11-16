package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerRenderSystemFactory
        extends LayerRenderSystemFactory<ObstacleLayerRenderSystem, ObstacleLayerRenderSystemPrototype>
{
    public ObstacleLayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        super(viewRenderer, effectFactory);
    }

    @Override
    public Class<ObstacleLayerRenderSystemPrototype> getFactoryType() {
        return ObstacleLayerRenderSystemPrototype.class;
    }

    @Override
    protected ObstacleLayerRenderSystem createEntitySystem(ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect, int priority) {
        return new ObstacleLayerRenderSystem(viewRenderer, spriteBatch, effect, priority);
    }
}
