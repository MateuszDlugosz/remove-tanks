package remove.tanks.game.level.engine.entity.component.render;

import com.google.common.base.MoreObjects;
import remove.tanks.game.graphics.view.ViewPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ViewComponentPrefab extends ComponentPrefab {
    private final List<ViewPrefab> viewPrefabs;

    public ViewComponentPrefab(List<ViewPrefab> viewPrefabs) {
        this.viewPrefabs = viewPrefabs;
    }

    public List<ViewPrefab> getViewPrefabs() {
        return viewPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("viewPrefabs", viewPrefabs)
                .toString();
    }
}
