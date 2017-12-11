package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystem extends IteratingSystem {
    private final Game2DCamera game2DCamera;

    public CameraTrackSystem(int priority, Game2DCamera game2DCamera) {
        super(EntityFamily.CameraTrackingFamily.getFamily(), priority);
        this.game2DCamera = game2DCamera;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent physicsComponent = PhysicsComponent.MAPPER.get(entity);
        CameraTrackComponent cameraTrackComponent = CameraTrackComponent.MAPPER.get(entity);
        game2DCamera.getCamera().position.set(
                new Vector2(
                        physicsComponent.getPosition().getX() + cameraTrackComponent.getPosition().getX(),
                        physicsComponent.getPosition().getY() + cameraTrackComponent.getPosition().getY()
                ),
                0
        );
    }
}
