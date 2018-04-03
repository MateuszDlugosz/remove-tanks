package remove.tanks.game.level.event.entity.create;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.utility.create.CreateEntry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEntityEvent implements EntityEvent {
    private final List<CreateEntry> createEntries;
    private final Entity entity;

    public RandomCreateEntityEvent(List<CreateEntry> createEntries, Entity entity) {
        this.createEntries = createEntries;
        this.entity = entity;
    }

    public List<CreateEntry> getCreateEntries() {
        return createEntries;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
