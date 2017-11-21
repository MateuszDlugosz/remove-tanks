package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemFactory<T extends LayerRenderSystem, U extends LayerRenderSystemPrototype>
        implements RegistrableEntitySystemFactory<T, U>
{
    private final ViewRenderer viewRenderer;
    private final EffectFactory effectFactory;

    public LayerRenderSystemFactory(ViewRenderer viewRenderer, EffectFactory effectFactory) {
        this.viewRenderer = viewRenderer;
        this.effectFactory = effectFactory;
    }

    @Override
    public final T createEntitySystem(U prototype, ResourceRegistry resourceRegistry) {
        return createEntitySystem(
                viewRenderer,
                resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                effectFactory.createEffect(prototype.getEffectPrototype()),
                prototype.getPriority()
        );
    }

    protected abstract T createEntitySystem(ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect, int priority);
}
