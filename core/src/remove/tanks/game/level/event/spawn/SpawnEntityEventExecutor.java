package remove.tanks.game.level.event.spawn;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntitySpawner;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntityEventExecutor implements RegistrableEventExecutor<SpawnEntityEvent> {
    private final EntitySpawner entitySpawner;
    private final EntityFactory entityFactory;

    public SpawnEntityEventExecutor(
            EntitySpawner entitySpawner,
            EntityFactory entityFactory
    ) {
        this.entitySpawner = entitySpawner;
        this.entityFactory = entityFactory;
    }

    @Override
    public void executeEvent(SpawnEntityEvent event, Level level) {
        entitySpawner.spawnEntity(
                entityFactory.createEntity(
                        event.getEntityPrototype(),
                        level
                ),
                event.getPosition(),
                level
        );
    }

    @Override
    public Class<SpawnEntityEvent> getExecutorType() {
        return SpawnEntityEvent.class;
    }
}
