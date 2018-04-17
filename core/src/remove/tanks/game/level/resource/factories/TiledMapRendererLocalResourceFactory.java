package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapRendererLocalResourceFactory extends AbstractLocalResourceFactory<TiledMapRenderer> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.TiledMapRendererResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.TiledMapResource,
                ResourceType.SpriteBatchResource,
                ResourceType.WorldScaleResource
        };
    }

    @Override
    protected TiledMapRenderer createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return new OrthogonalTiledMapRenderer(
                registry.getResource(ResourceType.TiledMapResource, TiledMap.class),
                1f / registry.getResource(ResourceType.WorldScaleResource, Scale.class).getValue(),
                registry.getResource(ResourceType.SpriteBatchResource, SpriteBatch.class)
        );
    }
}
