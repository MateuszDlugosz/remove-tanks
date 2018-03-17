package remove.tanks.game.level.event.entity.ammo;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEntityEvent implements EntityEvent {
    private final Entity entity;

    public AmmoLevelUpEntityEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
