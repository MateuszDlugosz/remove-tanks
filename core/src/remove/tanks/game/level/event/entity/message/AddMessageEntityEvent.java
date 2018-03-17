package remove.tanks.game.level.event.entity.message;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.utility.stage.broker.message.Message;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEntityEvent implements EntityEvent {
    private final Entity entity;
    private final Message message;

    public AddMessageEntityEvent(Entity entity, Message message) {
        this.entity = entity;
        this.message = message;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public Message getMessage() {
        return message;
    }
}
