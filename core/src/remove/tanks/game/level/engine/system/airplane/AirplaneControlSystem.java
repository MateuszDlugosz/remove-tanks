package remove.tanks.game.level.engine.system.airplane;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AirplaneSpawnerComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.event.entity.destroy.DestroyEntityEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.boundary.Boundary;

import java.util.Collections;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneControlSystem extends EntitySystem {
    private static final float MAX_CAMERA_ZOOM = 1.5f;
    private static final float MIN_CAMERA_ZOOM = 1f;
    private static final float ZOOM_STEP = 0.008f;

    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private final Game2DCamera game2DCamera;
    private final Boundary boundary;
    private int spawnQueue;

    public AirplaneControlSystem(
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus,
            Game2DCamera game2DCamera,
            Boundary boundary
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.game2DCamera = game2DCamera;
        this.boundary = boundary;
        this.spawnQueue = 0;
    }

    public void spawnAirplane() {
        spawnQueue++;
    }

    @Override
    public void update(float deltaTime) {
        spawnAirplanes();
        cameraZoom();
        removeAirplanes();
    }

    private void spawnAirplanes() {
        if (spawnQueue > 0) {
            ImmutableArray<Entity> spawners = getAirplaneSpawners();
            for (int i = 0; i < spawnQueue; i++) {
                Optional.ofNullable(getRandomAirplaneSpawner(spawners)).ifPresent(s -> {
                    eventBus.post(new CreateEvent(Collections.singletonList(new CreateEntry(
                            AirplaneSpawnerComponent.MAPPER.get(s).getEntityPrefabCode(),
                            PhysicsComponent.MAPPER.get(s).getPosition()
                    ))));
                    spawnQueue -= 1;
                });
            }
        }
    }

    private ImmutableArray<Entity> getAirplaneSpawners() {
        return getEngine().getEntitiesFor(EntityFamily.AirplaneSpawnerFamily.getFamily());
    }

    private Entity getRandomAirplaneSpawner(ImmutableArray<Entity> entities) {
        if (entities.size() == 0) return null;
        return entities.get(randomNumberGenerator.getRandomInt(0, entities.size() - 1));
    }

    private void cameraZoom() {
        if (getNumberOfAirplanes() > 0) {
            cameraZoomOut();
        } else {
            cameraZoomNormal();
        }
    }

    private void cameraZoomOut() {
        game2DCamera.getCamera().zoom += ZOOM_STEP;
        if (game2DCamera.getCamera().zoom > MAX_CAMERA_ZOOM) {
            game2DCamera.getCamera().zoom = MAX_CAMERA_ZOOM;
        }
    }

    private void cameraZoomNormal() {
        game2DCamera.getCamera().zoom -= ZOOM_STEP;
        if (game2DCamera.getCamera().zoom < MIN_CAMERA_ZOOM) {
            game2DCamera.getCamera().zoom = MIN_CAMERA_ZOOM;
        }
    }

    private int getNumberOfAirplanes() {
        return getEngine().getEntitiesFor(EntityFamily.AirplaneFamily.getFamily()).size();
    }

    private void removeAirplanes() {
        ImmutableArray<Entity> entities = getAirplanes();
        for (int i = 0; i < entities.size(); i++) {
            if (!isOnMap(entities.get(i))) {
                eventBus.post(new DestroyEntityEvent(entities.get(i)));
            }
        }
    }

    private ImmutableArray<Entity> getAirplanes() {
        return getEngine().getEntitiesFor(EntityFamily.AirplaneFamily.getFamily());
    }

    private boolean isOnMap(Entity entity) {
        switch (DirectionComponent.MAPPER.get(entity).getDirection()) {
            case Left:
                if (PhysicsComponent.MAPPER.get(entity).getPosition().getX()
                        < boundary.getMinX() - boundary.getWidth() * 0.5f)
                    return false;
                break;
            case Right:
                if (PhysicsComponent.MAPPER.get(entity).getPosition().getX()
                        > boundary.getMaxX() + boundary.getWidth() * 0.5f)
                    return false;
                break;
            case Up:
                if (PhysicsComponent.MAPPER.get(entity).getPosition().getY()
                        > boundary.getMaxY() + boundary.getHeight() * 0.5f)
                    return false;
                break;
            case Down:
                if (PhysicsComponent.MAPPER.get(entity).getPosition().getY()
                        < boundary.getMinY() - boundary.getHeight() * 0.5f)
                    return false;
                break;
            case None:
                return false;
        }
        return true;
    }
}
