package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.maps.tiled.TiledMap;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.boundary.Boundaries;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapBoundariesInternalResourceFactory
        extends AbstractInternalResourceFactory<Boundaries>
{
    private final MapPropertiesConverter mapPropertiesConverter;

    public TiledMapBoundariesInternalResourceFactory(MapPropertiesConverter mapPropertiesConverter) {
        this.mapPropertiesConverter = mapPropertiesConverter;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.TiledMapBoundaries.toString();
    }

    @Override
    protected Boundaries getResourceObject(ResourceRegistry registry) {
        Game2DCamera gameCamera = registry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class);
        Scale worldScale = registry.getResource(LevelResource.WorldScale.toString(), Scale.class);
        Properties properties = mapPropertiesConverter.convertProperties(
                registry.getResource(LevelResource.TiledMap.toString(), TiledMap.class)
                        .getProperties()
        );
        float viewportHalfWidth = gameCamera.getViewport().getWorldWidth() * 0.5f;
        float viewportHalfHeight = gameCamera.getViewport().getWorldHeight() * 0.5f;
        float mapWidth = worldScale.scaleValue(properties.getInt("tilewidth") * properties.getInt("width"));
        float mapHeight = worldScale.scaleValue(properties.getInt("tileheight") * properties.getInt("height"));
        return new Boundaries(
                viewportHalfWidth,
                mapWidth - viewportHalfWidth,
                viewportHalfHeight,
                mapHeight - viewportHalfHeight
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.TiledMap.toString(),
                LevelResource.GameCamera.toString(),
                LevelResource.WorldScale.toString()
        };
    }
}
