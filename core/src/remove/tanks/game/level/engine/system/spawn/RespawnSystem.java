package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.event.life.RemoveLifeEvent;
import remove.tanks.game.level.event.points.ResetPointsMultiplierEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RespawnSystem extends EntitySystem {
    private final Timer timer;
    private final Properties properties;
    private final EventBus eventBus;
    private final String entityPrefabCode;
    private boolean freeRespawn;

    public RespawnSystem(
            int priority,
            Timer timer,
            Properties properties,
            EventBus eventBus,
            String entityPrefabCode
    ) {
        super(priority);
        this.timer = timer;
        this.properties = properties;
        this.eventBus = eventBus;
        this.entityPrefabCode = entityPrefabCode;
        this.freeRespawn = true;
    }

    @Override
    public void update(float deltaTime) {
        if (!isPlayerExists()) {
            if (isAvailableLife() || freeRespawn) {
                if (timer.isCompleted()) {
                    respawnPlayer();
                    timer.reset();
                } else {
                    timer.update(deltaTime);
                }
            }
        }
    }

    private boolean isPlayerExists() {
        return getEngine().getEntitiesFor(EntityFamily.InputFamily.getFamily()).size() > 0;
    }

    private boolean isAvailableLife() {
        return properties.getInt(LevelProperty.LevelLifes.getName()) > 0;
    }

    private void respawnPlayer() {
        eventBus.post(new CreateEvent(Lists.newArrayList(new CreateEntry(entityPrefabCode,
                PhysicsComponent.MAPPER.get(getRandomRespawn()).getPosition()))));
        eventBus.post(ResetPointsMultiplierEvent.INSTANCE);

        if (!freeRespawn) {
            eventBus.post(RemoveLifeEvent.INSTANCE);
        } else {
            freeRespawn = false;
        }
    }

    private Entity getRandomRespawn() {
        ImmutableArray<Entity> entities =
                getEngine().getEntitiesFor(EntityFamily.RespawnFamily.getFamily());
        if (entities.size() < 1) {
            throw new RespawnNotFoundException();
        }
        return entities.random();
    }
}
