package remove.tanks.game.physics.light.world.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import remove.tanks.game.physics.light.world.WorldLight;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderer {
    public void render(WorldLight worldLight, OrthographicCamera camera) {
        worldLight.setCombinedMatrix(camera);
        worldLight.updateAndRender();
    }
}
