package remove.tanks.game.graphics.camera.effect;

import remove.tanks.game.graphics.camera.Game2DCamera;

/**
 * @author Mateusz Długosz
 */
public interface CameraEffect {
    void update(float delta, Game2DCamera camera);
    boolean isCompleted();
}
