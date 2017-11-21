package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.EntityDestroyer;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEventExecutor implements RegistrableEventExecutor<DestroyEntityEvent> {
    private final EntityDestroyer entityDestroyer;

    public DestroyEntityEventExecutor(EntityDestroyer entityDestroyer) {
        this.entityDestroyer = entityDestroyer;
    }

    @Override
    public void executeEvent(DestroyEntityEvent event, Level level) {
        entityDestroyer.destroyEntity(event.getEntity(), level);
    }

    @Override
    public Class<DestroyEntityEvent> getExecutorType() {
        return DestroyEntityEvent.class;
    }
}
