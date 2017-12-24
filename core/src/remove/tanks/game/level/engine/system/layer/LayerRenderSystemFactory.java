package remove.tanks.game.level.engine.system.layer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.view.renderer.ViewRenderer;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public abstract class LayerRenderSystemFactory<T extends LayerRenderSystem, U extends LayerRenderSystemPrototype>
        implements RegistrableEntitySystemFactory<T, U>
{
    private final ViewRenderer viewRenderer;

    public LayerRenderSystemFactory(ViewRenderer viewRenderer) {
        this.viewRenderer = viewRenderer;
    }

    @Override
    public final T createEntitySystem(U prototype, ResourceRegistry resourceRegistry) {
        try {
            return createEntitySystem(
                    prototype.getPriority(),
                    viewRenderer,
                    resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                    resourceRegistry.getResource(LevelResource.AssetStorage.toString(), AssetStorage.class)
                            .getAsset("highlight-effect", Effect.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    protected abstract T createEntitySystem(int priority, ViewRenderer viewRenderer, SpriteBatch spriteBatch, Effect effect);
}
