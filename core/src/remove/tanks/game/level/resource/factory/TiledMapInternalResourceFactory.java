package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapInternalResourceFactory
        extends AbstractInternalResourceFactory<TiledMap>
{
    private final TmxMapLoader tmxMapLoader;

    public TiledMapInternalResourceFactory(TmxMapLoader tmxMapLoader) {
        this.tmxMapLoader = tmxMapLoader;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.TiledMap.toString();
    }

    @Override
    protected TiledMap getResourceObject(ResourceRegistry registry) {
        return tmxMapLoader.load(
                registry.getResource(LevelResource.Properties.toString(), Properties.class)
                        .getString(LevelProperty.LevelResourceTiledMapFilename.getName())
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.Properties.toString()
        };
    }
}
