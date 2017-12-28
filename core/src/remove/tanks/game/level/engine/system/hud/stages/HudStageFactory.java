package remove.tanks.game.level.engine.system.hud.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.broker.MessageBar;
import remove.tanks.game.level.engine.system.hud.stages.broker.MessageBarFactory;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBar;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.Widget;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStageFactory {
    private final WidgetFactory widgetFactory;
    private final StateBarFactory stateBarFactory;
    private final MessageBarFactory messageBarFactory;

    public HudStageFactory(
            WidgetFactory widgetFactory,
            StateBarFactory stateBarFactory,
            MessageBarFactory messageBarFactory
    ) {
        this.widgetFactory = widgetFactory;
        this.stateBarFactory = stateBarFactory;
        this.messageBarFactory = messageBarFactory;
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
                    createWidgets(prototype, table, resourceRegistry),
                    createStateBar(prototype, table, resourceRegistry, prototype.getWidgetPrototypes().size()),
                    createMessageBar(prototype, table, resourceRegistry, prototype.getWidgetPrototypes().size())
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

    private List<Widget> createWidgets(HudStagePrototype prototype, Table table, ResourceRegistry resourceRegistry) {
        List<Widget> widgets = widgetFactory.createWidgets(prototype.getWidgetPrototypes(), table, resourceRegistry);
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getTitleLabel()).expandX());
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getValueLabel()).expandX());
        return widgets;
    }

    private StateBar createStateBar(HudStagePrototype prototype, Table table, ResourceRegistry resourceRegistry, int colSpan) {
        StateBar stateBar = stateBarFactory.createStateBar(prototype.getStateBarPrototype(), resourceRegistry);
        table.row().expandY();
        table.add(stateBar.getLabel()).colspan(colSpan);
        return stateBar;
    }

    private MessageBar createMessageBar(HudStagePrototype prototype, Table table, ResourceRegistry resourceRegistry, int colSpan) {
        MessageBar messageBar = messageBarFactory.createMessageBar(prototype.getMessageBarPrototype(), resourceRegistry);
        Table helperTable = new Table();
        helperTable.add(messageBar.getImage()).right().bottom().padRight(20);
        helperTable.row();
        helperTable.add(messageBar.getMessageLabel()).right().bottom().pad(20);
        table.row().expand().colspan(colSpan);
        table.add(helperTable).right().bottom().pad(20);
        return messageBar;
    }
}
