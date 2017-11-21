package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class EntityController {
    private final EntitySpawner entitySpawner;
    private final EntityDestroyer entityDestroyer;

    public EntityController(
            EntitySpawner entitySpawner,
            EntityDestroyer entityDestroyer
    ) {
        this.entitySpawner = entitySpawner;
        this.entityDestroyer = entityDestroyer;
    }

    public void spawnEntity(Entity entity, Position position, Level level) {
        entitySpawner.spawnEntity(entity, position, level);
    }

    public void destroyEntity(Entity entity, Level level) {
        entityDestroyer.destroyEntity(entity, level);
    }
}
