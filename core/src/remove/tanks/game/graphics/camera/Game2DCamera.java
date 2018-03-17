package remove.tanks.game.graphics.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class Game2DCamera {
    private final OrthographicCamera camera;
    private final Viewport viewport;

    public Game2DCamera(OrthographicCamera camera, Viewport viewport) {
        if (viewport.getCamera() != camera) {
            throw new Game2DCameraInstantiationException();
        }
        this.camera = camera;
        this.viewport = viewport;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Boundary getCameraBoundaries() {
        float halfWidth = camera.viewportWidth * 0.5f;
        float halfHeight = camera.viewportHeight * 0.5f;
        return new Boundary(
                camera.position.x - halfWidth,
                camera.position.x + halfWidth,
                camera.position.y - halfHeight,
                camera.position.y + halfHeight
        );
    }

    public void update() {
        camera.update();
    }
}
