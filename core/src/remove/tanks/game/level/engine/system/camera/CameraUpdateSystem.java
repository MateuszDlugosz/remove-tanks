package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class CameraUpdateSystem extends EntitySystem {
    private final Game2DCamera game2DCamera;

    public CameraUpdateSystem(int priority, Game2DCamera game2DCamera) {
        super(priority);
        this.game2DCamera = game2DCamera;
    }

    @Override
    public void update(float deltaTime) {
        game2DCamera.getCamera().update();
    }
}
