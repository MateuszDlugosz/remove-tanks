package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEvent implements Event {
    private final EntityFamily entityFamily;

    public DestroyFamilyEvent(EntityFamily entityFamily) {
        this.entityFamily = entityFamily;
    }

    public EntityFamily getEntityFamily() {
        return entityFamily;
    }
}
