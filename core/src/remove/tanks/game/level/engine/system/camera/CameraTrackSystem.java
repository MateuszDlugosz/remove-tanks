package remove.tanks.game.level.engine.system.camera;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.camera.CameraTrackComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.utility.surface.boundary.Boundary;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackSystem extends EntitySystem {
    private final Game2DCamera game2DCamera;
    private final Boundary boundary;

    public CameraTrackSystem(int priority, Game2DCamera game2DCamera, Boundary boundary) {
        super(priority);
        this.game2DCamera = game2DCamera;
        this.boundary = boundary;
        this.game2DCamera.getCamera().position.set(boundary.getCenterPosition().getAsVector2(), 0);
    }

    @Override
    public void update(float deltaTime) {
        Optional.ofNullable(getFirstPriorityEntity()).ifPresent(e -> {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(e);
            CameraTrackComponent ctc = CameraTrackComponent.MAPPER.get(e);

            lockCameraX();
            lockCameraY();

            game2DCamera.setX(MathUtils.clamp(
                    pc.getPosition().getX() + ctc.getPosition().getX(),
                    boundary.getMinX(),
                    boundary.getMaxX()
            ));
            game2DCamera.setY(MathUtils.clamp(
                    pc.getPosition().getY() + ctc.getPosition().getY(),
                    boundary.getMinY(),
                    boundary.getMaxY()
            ));
        });
    }

    private void lockCameraX() {
        if (game2DCamera.getCameraBoundaries().getWidth() >= boundary.getWidth()) {
            game2DCamera.lockX(boundary.getCenterPosition().getX());
        } else {
            game2DCamera.unlockX();
        }
    }

    private void lockCameraY() {
        if (game2DCamera.getCameraBoundaries().getHeight() >= boundary.getHeight()) {
            game2DCamera.lockY(boundary.getCenterPosition().getY());
        } else {
            game2DCamera.unlockY();
        }
    }

    private Entity getFirstPriorityEntity() {
        List<Entity> entities = getSortedCameraTrackEntities();
        if (entities.size() > 0) {
            return entities.get(0);
        }
        return null;
    }

    private List<Entity> getSortedCameraTrackEntities() {
        List<Entity> entities = getCameraTrackEntities();
        entities.sort((e0, e1) -> {
            CameraTrackComponent ctc0 = CameraTrackComponent.MAPPER.get(e0);
            CameraTrackComponent ctc1 = CameraTrackComponent.MAPPER.get(e1);
            return ctc0.getPriority() - ctc1.getPriority();
        });
        return entities;
    }

    private List<Entity> getCameraTrackEntities() {
        return Arrays.asList(getEngine().getEntitiesFor(EntityFamily.CameraTrackFamily.getFamily()).toArray());
    }
}
