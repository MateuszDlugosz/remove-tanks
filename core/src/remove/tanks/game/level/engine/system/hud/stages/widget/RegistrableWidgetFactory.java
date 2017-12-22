package remove.tanks.game.level.engine.system.hud.stages.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableWidgetFactory<T extends Widget, U extends WidgetPrototype> {
    T createWidget(U prototype, Table table, ResourceRegistry resourceRegistry);
    Class<U> getFactoryType();
}
