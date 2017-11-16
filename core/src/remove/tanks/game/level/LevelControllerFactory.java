package remove.tanks.game.level;

import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;

/**
 * @author Mateusz Długosz
 */
public final class LevelControllerFactory {
    private final EntitySpawner entitySpawner;
    private final EntityDestroyer entityDestroyer;
    private final EntityFactory entityFactory;

    public LevelControllerFactory(
            EntitySpawner entitySpawner,
            EntityDestroyer entityDestroyer,
            EntityFactory entityFactory
    ) {
        this.entitySpawner = entitySpawner;
        this.entityDestroyer = entityDestroyer;
        this.entityFactory = entityFactory;
    }

    public LevelController createLevelController(Level level) {
        return new LevelController(level, entitySpawner, entityDestroyer, entityFactory);
    }
}
