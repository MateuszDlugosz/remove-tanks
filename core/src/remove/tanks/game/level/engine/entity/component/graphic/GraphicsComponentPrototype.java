package remove.tanks.game.level.engine.entity.component.graphic;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphic.view.ViewPrototype;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class GraphicsComponentPrototype implements ComponentPrototype {
    private final List<ViewPrototype> viewPrototypes;

    public GraphicsComponentPrototype(List<ViewPrototype> viewPrototypes) {
        this.viewPrototypes = viewPrototypes;
    }

    public List<ViewPrototype> getViewPrototypes() {
        return viewPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("viewPrototypes", viewPrototypes)
                .toString();
    }
}
