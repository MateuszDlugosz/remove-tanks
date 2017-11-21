package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityControllerFactory {
    private final EntitySpawner entitySpawner;
    private final EntityDestroyer entityDestroyer;

    public EntityControllerFactory(
            EntitySpawner entitySpawner,
            EntityDestroyer entityDestroyer
    ) {
        this.entitySpawner = entitySpawner;
        this.entityDestroyer = entityDestroyer;
    }

    public EntityController createLevelEntityController() {
        return new EntityController(entitySpawner, entityDestroyer);
    }
}
