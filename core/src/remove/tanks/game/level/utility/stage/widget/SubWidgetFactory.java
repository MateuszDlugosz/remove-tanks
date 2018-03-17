package remove.tanks.game.level.utility.stage.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface SubWidgetFactory<T extends Widget, U extends WidgetPrefab> {
    T createWidget(U prefab, Table table, ResourceRegistry registry);
    Class<U> getFactoryType();
}
