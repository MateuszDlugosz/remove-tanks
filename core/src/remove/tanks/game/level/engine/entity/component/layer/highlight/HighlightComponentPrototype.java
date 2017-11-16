package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class HighlightComponentPrototype implements ComponentPrototype {
    private final float highlightTime;

    public HighlightComponentPrototype(float highlightTime) {
        this.highlightTime = highlightTime;
    }

    public float getHighlightTime() {
        return highlightTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("highlightTime", highlightTime)
                .toString();
    }
}
