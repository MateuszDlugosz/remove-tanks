package remove.tanks.game.level.engine.system.world;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.physics.light.world.renderer.WorldLightRenderer;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderSystem extends EntitySystem {
    private final WorldLightRenderer worldLightRenderer;
    private final WorldLight worldLight;
    private final OrthographicCamera orthographicCamera;

    public WorldLightRenderSystem(
            int priority,
            WorldLightRenderer worldLightRenderer,
            WorldLight worldLight,
            OrthographicCamera orthographicCamera
    ) {
        super(priority);
        this.worldLightRenderer = worldLightRenderer;
        this.worldLight = worldLight;
        this.orthographicCamera = orthographicCamera;
    }

    @Override
    public void update(float deltaTime) {
        worldLightRenderer.render(worldLight, orthographicCamera);
    }
}
