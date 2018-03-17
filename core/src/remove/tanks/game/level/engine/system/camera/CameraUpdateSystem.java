package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystem extends EntitySystem {
    private final Game2DCamera game2DCamera;
    private final Boundary boundary;

    public CameraUpdateSystem(int priority, Game2DCamera game2DCamera, Boundary boundary) {
        super(priority);
        this.game2DCamera = game2DCamera;
        this.boundary = boundary;
        this.game2DCamera.getCamera().position.set(boundary.getCenterPosition().getAsVector2(), 0);
    }

    @Override
    public void update(float deltaTime) {
        game2DCamera.getCamera().position.set(
                boundary.clampX(game2DCamera.getCamera().position.x),
                boundary.clampY(game2DCamera.getCamera().position.y),
                0
        );
        game2DCamera.getCamera().update();
    }
}
