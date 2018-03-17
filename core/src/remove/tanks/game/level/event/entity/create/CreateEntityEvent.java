package remove.tanks.game.level.event.entity.create;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.utility.create.CreateEntry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntityEvent implements EntityEvent {
    private final Entity entity;
    private final List<CreateEntry> createEntries;

    public CreateEntityEvent(Entity entity, List<CreateEntry> createEntries) {
        this.entity = entity;
        this.createEntries = createEntries;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public List<CreateEntry> getCreateEntries() {
        return createEntries;
    }
}
