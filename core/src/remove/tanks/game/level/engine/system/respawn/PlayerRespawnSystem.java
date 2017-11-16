package remove.tanks.game.level.engine.system.respawn;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototype;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.event.ModifyPropertyEvent;
import remove.tanks.game.level.engine.event.SpawnEntityEvent;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnSystem extends EntitySystem {
    private final Timer respawnTimer;
    private final Properties properties;
    private final EventBus eventBus;
    private final EntityPrototype playerPrototype;
    private boolean freeRespawn;

    public PlayerRespawnSystem(
            Timer respawnTimer,
            Properties properties,
            EventBus eventBus,
            EntityPrototype playerPrototype,
            int priority
    ) {
        super(priority);
        this.respawnTimer = respawnTimer;
        this.properties = properties;
        this.eventBus = eventBus;
        this.playerPrototype = playerPrototype;
        this.freeRespawn = true;
    }

    @Override
    public void update(float deltaTime) {
        if (!playerExists()) {
            if (isAvailableLife() || freeRespawn) {
                if (respawnTimer.isComplete()) {
                    respawnPlayer();
                    respawnTimer.reset();
                } else {
                    respawnTimer.update(deltaTime);
                }
            }
        }
    }

    private boolean playerExists() {
        return getEngine().getEntitiesFor(EntityFamily.PlayerControlledFamily.getFamily()).size() > 0;
    }

    private boolean isAvailableLife() {
        return properties.getInt(LevelProperty.LevelLifes.getName()) > 0;
    }

    private void respawnPlayer() {
        eventBus.post(new SpawnEntityEvent(
                playerPrototype,
                PhysicsComponent.MAPPER.get(getRandomRespawn()).getPosition()
        ));

        if (!freeRespawn) {
            eventBus.post(new ModifyPropertyEvent(
                    LevelProperty.LevelLifes,
                    String.valueOf(properties.getInt(LevelProperty.LevelLifes.getName()) - 1)
            ));
        } else {
            freeRespawn = false;
        }
    }

    private Entity getRandomRespawn() {
        ImmutableArray<Entity> entities =
                getEngine().getEntitiesFor(EntityFamily.PlayerRespawnFamily.getFamily());
        if (entities.size() < 1) {
            throw new PlayerRespawnNotExistsException();
        }
        return entities.random();
    }
}
