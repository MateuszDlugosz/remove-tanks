package remove.tanks.game.graphic.view.updater;

import remove.tanks.game.graphic.view.UpdatableView;
import remove.tanks.game.graphic.view.View;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ViewUpdater {
    public void updateViews(List<View> views, float delta) {
        views.forEach(v -> this.updateView(v, delta));
    }

    public void updateView(View view, float delta) {
        if (view instanceof UpdatableView) {
            ((UpdatableView) view).update(delta);
        }
    }
}
