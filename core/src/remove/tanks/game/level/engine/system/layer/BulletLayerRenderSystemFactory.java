package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerRenderSystemFactory
        extends LayerRenderSystemFactory<BulletLayerRenderSystem, BulletLayerRenderSystemPrototype>
{
    public BulletLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        super(viewRenderer);
    }

    @Override
    public Class<BulletLayerRenderSystemPrototype> getFactoryType() {
        return BulletLayerRenderSystemPrototype.class;
    }

    @Override
    protected BulletLayerRenderSystem createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect) {
        return new BulletLayerRenderSystem(priority, viewRenderer, spriteBatch, effect);
    }
}
