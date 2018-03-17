package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.view.renderer.ViewRenderer;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractLayerRenderSystemFactory<T extends AbstractLayerRenderSystem, U extends AbstractLayerRenderSystemPrefab>
        implements SubEntitySystemFactory<T, U>
{
    private final ViewRenderer viewRenderer;

    public AbstractLayerRenderSystemFactory(ViewRenderer viewRenderer) {
        this.viewRenderer = viewRenderer;
    }

    @Override
    public final T createEntitySystem(U prefab, ResourceRegistry registry) {
        try {
            return createEntityLayerRenderSystem(prefab, viewRenderer, registry.getResource(ResourceType.SpriteBatchResource, SpriteBatch.class));
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    protected abstract T createEntityLayerRenderSystem(U prefab, ViewRenderer viewRenderer, SpriteBatch spriteBatch);

    @Override
    public abstract Class<U> getFactoryType();
}
