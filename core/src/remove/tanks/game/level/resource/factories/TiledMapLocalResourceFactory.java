package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapLocalResourceFactory extends AbstractLocalResourceFactory<TiledMap> {
    private final TmxMapLoader tmxMapLoader;

    public TiledMapLocalResourceFactory(TmxMapLoader tmxMapLoader) {
        this.tmxMapLoader = tmxMapLoader;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.TiledMapResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
            ResourceType.LevelPrefabResource
        };
    }

    @Override
    protected TiledMap createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return tmxMapLoader.load(registry.getResource(ResourceType.LevelPrefabResource,
                LevelPrefab.class).getTiledMapFilename());
    }

    @Override
    protected ResourceDisposer<TiledMap> createResourceDisposer() {
        return TiledMap::dispose;
    }
}
