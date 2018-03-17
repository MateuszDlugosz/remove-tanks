package remove.tanks.game.level.event.entity.state;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEntityEvent implements EntityEvent {
    private final Entity entity;
    private final LevelState levelState;

    public ChangeLevelStateEntityEvent(Entity entity, LevelState levelState) {
        this.entity = entity;
        this.levelState = levelState;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public LevelState getLevelState() {
        return levelState;
    }
}
