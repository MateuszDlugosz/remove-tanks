package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.utility.boundary.Boundaries;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystem extends EntitySystem {
    private final Game2DCamera game2DCamera;
    private final Boundaries boundaries;

    public CameraUpdateSystem(Game2DCamera game2DCamera, Boundaries boundaries, int priority) {
        super(priority);
        this.game2DCamera = game2DCamera;
        this.boundaries = boundaries;
        this.game2DCamera.getCamera().position.set(boundaries.getCenterPosition().getAsVector2(), 0);
    }

    @Override
    public void update(float deltaTime) {
        game2DCamera.getCamera().position.set(
                boundaries.clampX(game2DCamera.getCamera().position.x),
                boundaries.clampY(game2DCamera.getCamera().position.y),
                0
        );
        game2DCamera.getCamera().update();
    }
}
