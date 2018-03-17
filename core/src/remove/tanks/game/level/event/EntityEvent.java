package remove.tanks.game.level.event;

import com.badlogic.ashley.core.Entity;

/**
 * @author Mateusz Długosz
 */
public interface EntityEvent extends Event {
    Entity getEntity();
}
