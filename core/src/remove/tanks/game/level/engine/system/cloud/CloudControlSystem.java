package remove.tanks.game.level.engine.system.cloud;

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
public final class CloudControlSystem extends EntitySystem {
    private final EventBus eventBus;
    private final Boundary boundary;

    public CloudControlSystem(EventBus eventBus, Boundary boundary) {
        this.eventBus = eventBus;
        this.boundary = boundary;
    }

    @Override
    public void update(float deltaTime) {
        removeClouds();
    }

    private void removeClouds() {
        ImmutableArray<Entity> entities = getClouds();
        for (int i = 0; i < entities.size(); i++) {
            if (!isOnMap(entities.get(i))) {
                eventBus.post(new DestroyEntityEvent(entities.get(i)));
            }
        }
    }

    private ImmutableArray<Entity> getClouds() {
        return getEngine().getEntitiesFor(EntityFamily.CloudFamily.getFamily());
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
