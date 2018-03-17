package remove.tanks.game.level.engine.system.render.map;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.map.MapLayerName;

/**
 * @author Mateusz Długosz
 */
public final class GroundMapLayerRenderSystem extends EntitySystem {
    private final int[] indexes;
    private final TiledMapRenderer tiledMapRenderer;
    private final Game2DCamera game2DCamera;

    public GroundMapLayerRenderSystem(
            int priority,
            TiledMapRenderer tiledMapRenderer,
            Game2DCamera game2DCamera
    ) {
        super(priority);
        this.indexes = new int[] { MapLayerName.GroundTiledLayer.getIndex() };
        this.tiledMapRenderer = tiledMapRenderer;
        this.game2DCamera = game2DCamera;
    }

    @Override
    public void update(float deltaTime) {
        tiledMapRenderer.setView(game2DCamera.getCamera());
        tiledMapRenderer.render(indexes);
    }
}
