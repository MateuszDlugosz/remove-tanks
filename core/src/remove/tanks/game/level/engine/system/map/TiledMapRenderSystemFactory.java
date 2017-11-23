package remove.tanks.game.level.engine.system.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapRenderSystemFactory
        implements RegistrableEntitySystemFactory<TiledMapRenderSystem, TiledMapRenderSystemPrototype>
{
    @Override
    public TiledMapRenderSystem createEntitySystem(TiledMapRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new TiledMapRenderSystem(
                prototype.getPriority(),
                createTiledMapRenderer(
                        resourceRegistry.getResource(LevelResource.TiledMap.toString(), TiledMap.class),
                        resourceRegistry.getResource(LevelResource.WorldScale.toString(), Scale.class),
                        resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class)
                ),
                resourceRegistry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class).getCamera()
        );
    }

    private TiledMapRenderer createTiledMapRenderer(TiledMap tiledMap, Scale scale, SpriteBatch spriteBatch) {
        return new OrthogonalTiledMapRenderer(tiledMap, 1 / scale.getValue(), spriteBatch);
    }

    @Override
    public Class<TiledMapRenderSystemPrototype> getFactoryType() {
        return TiledMapRenderSystemPrototype.class;
    }
}
