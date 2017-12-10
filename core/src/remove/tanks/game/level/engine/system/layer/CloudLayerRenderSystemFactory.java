package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerRenderSystemFactory
        extends LayerRenderSystemFactory<CloudLayerRenderSystem, CloudLayerRenderSystemPrototype>
{
    public CloudLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    public Class<CloudLayerRenderSystemPrototype> getFactoryType() {
        return CloudLayerRenderSystemPrototype.class;
    }

    @Override
    protected CloudLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new CloudLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
