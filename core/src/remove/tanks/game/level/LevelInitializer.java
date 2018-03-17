package remove.tanks.game.level;

import remove.tanks.game.level.engine.entity.EntityTiledMapInitializer;

/**
 * @author Mateusz Długosz
 */
public final class LevelInitializer {
    private final EntityTiledMapInitializer entityTiledMapInitializer;

    public LevelInitializer(EntityTiledMapInitializer entityTiledMapInitializer) {
        this.entityTiledMapInitializer = entityTiledMapInitializer;
    }

    public void initializeLevel(Level level) {
        try {
            entityTiledMapInitializer.initializeEntities(level.getResourceRegistry());
        } catch (Exception e) {
            throw new LevelInitializeException(e);
        }
    }
}
