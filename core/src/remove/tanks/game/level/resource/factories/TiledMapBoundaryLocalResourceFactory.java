package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.maps.tiled.TiledMap;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.boundary.Boundary;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapBoundaryLocalResourceFactory extends AbstractLocalResourceFactory<Boundary> {
    private final MapPropertiesConverter mapPropertiesConverter;

    public TiledMapBoundaryLocalResourceFactory(MapPropertiesConverter mapPropertiesConverter) {
        this.mapPropertiesConverter = mapPropertiesConverter;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.TiledMapBoundaryResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.TiledMapResource,
                ResourceType.WorldScaleResource,
                ResourceType.GameCameraResource
        };
    }

    @Override
    protected Boundary createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        Game2DCamera gameCamera = registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class);
        Scale worldScale = registry.getResource(ResourceType.WorldScaleResource, Scale.class);
        Properties properties = mapPropertiesConverter.convertProperties(
                registry.getResource(ResourceType.TiledMapResource, TiledMap.class)
                        .getProperties()
        );
        float viewportHalfWidth = gameCamera.getViewport().getWorldWidth() * 0.5f;
        float viewportHalfHeight = gameCamera.getViewport().getWorldHeight() * 0.5f;
        float mapWidth = worldScale.scaleValue(properties.getInt("tilewidth") * properties.getInt("width"));
        float mapHeight = worldScale.scaleValue(properties.getInt("tileheight") * properties.getInt("height"));
        return new Boundary(
                viewportHalfWidth,
                mapWidth - viewportHalfWidth,
                viewportHalfHeight,
                mapHeight - viewportHalfHeight
        );
    }

    @Override
    protected ResourceDisposer<Boundary> createResourceDisposer() {
        return null;
    }
}
