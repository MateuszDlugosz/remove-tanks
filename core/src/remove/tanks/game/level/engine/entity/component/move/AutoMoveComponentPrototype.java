package remove.tanks.game.level.engine.entity.component.move;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentPrototype implements ComponentPrototype {
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
