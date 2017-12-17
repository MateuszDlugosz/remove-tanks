package remove.tanks.game.graphic.camera.effect;

import remove.tanks.game.graphic.camera.Game2DCamera;

/**
 * @author Mateusz Długosz
 */
public interface CameraEffect {
    void update(float delta, Game2DCamera camera);
    boolean isCompleted();
}
