package remove.tanks.game.level.engine.system.map;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapRenderSystem extends EntitySystem {
    private final TiledMapRenderer tiledMapRenderer;
    private final OrthographicCamera orthographicCamera;

    public TiledMapRenderSystem(TiledMapRenderer tiledMapRenderer, OrthographicCamera orthographicCamera, int priority) {
        super(priority);
        this.tiledMapRenderer = tiledMapRenderer;
        this.orthographicCamera = orthographicCamera;
    }

    @Override
    public void update(float deltaTime) {
        tiledMapRenderer.setView(orthographicCamera);
        tiledMapRenderer.render();
    }
}
