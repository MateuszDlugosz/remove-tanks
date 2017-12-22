package remove.tanks.game.level.engine.system.hud.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBar;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarFactory;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarPrototype;
import remove.tanks.game.level.engine.system.hud.stages.widget.Widget;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStageFactory {
    private final WidgetFactory widgetFactory;
    private final StateBarFactory stateBarFactory;

    public HudStageFactory(
            WidgetFactory widgetFactory,
            StateBarFactory stateBarFactory
    ) {
        this.widgetFactory = widgetFactory;
        this.stateBarFactory = stateBarFactory;
    }

    public HudStage createHudStage(HudStagePrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            Stage stage = createStage(
                    resourceRegistry.getResource(LevelResource.HudCamera.toString(), Game2DCamera.class),
                    resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class)
            );
            Table table = createTable();
            stage.addActor(table);
            return new HudStage(
                    stage,
                    createWidgets(prototype.getWidgetPrototypes(), table, resourceRegistry),
                    createStateBar(prototype.getStateBarPrototype(), table, resourceRegistry, prototype.getWidgetPrototypes().size())
            );
        } catch (Exception e) {
            throw new HudStageCreateException(prototype, e);
        }
    }

    private Stage createStage(Game2DCamera hudCamera, SpriteBatch spriteBatch) {
        return new Stage(hudCamera.getViewport(), spriteBatch);
    }

    private Table createTable() {
        Table table = new Table();
        table.setFillParent(true);
        table.top();
        return table;
    }

    private List<Widget> createWidgets(List<WidgetPrototype> widgetPrototypes, Table table, ResourceRegistry resourceRegistry) {
        List<Widget> widgets = widgetFactory.createWidgets(widgetPrototypes, table, resourceRegistry);
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getTitleLabel()).expandX());
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getValueLabel()).expandX());
        return widgets;
    }

    private StateBar createStateBar(StateBarPrototype prototype, Table table, ResourceRegistry resourceRegistry, int colSpan) {
        StateBar stateBar = stateBarFactory.createStateBar(prototype, resourceRegistry);
        table.row().expandY();
        table.add(stateBar.getLabel()).colspan(colSpan);
        return stateBar;
    }
}
