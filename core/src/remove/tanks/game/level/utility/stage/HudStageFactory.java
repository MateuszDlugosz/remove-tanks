package remove.tanks.game.level.utility.stage;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.broker.MessageBar;
import remove.tanks.game.level.utility.stage.broker.MessageBarFactory;
import remove.tanks.game.level.utility.stage.state.StateBar;
import remove.tanks.game.level.utility.stage.state.StateBarFactory;
import remove.tanks.game.level.utility.stage.widget.Widget;
import remove.tanks.game.level.utility.stage.widget.WidgetFactory;

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

    public HudStage createHudStage(HudStagePrefab prefab, ResourceRegistry registry) {
        try {
            Stage stage = createStage(
                    registry.getResource(ResourceType.UICameraResource, Game2DCamera.class),
                    registry.getResource(ResourceType.SpriteBatchResource, SpriteBatch.class)
            );
            Table table = createTable();
            stage.addActor(table);
            return new HudStage(
                    stage,
                    createWidgets(prefab, table, registry),
                    createStateBar(prefab, table, registry, prefab.getWidgetPrefabs().size()),
                    createMessageBar(prefab, table, registry, prefab.getWidgetPrefabs().size())
            );
        } catch (Exception e) {
            throw new HudStageCreateException(prefab, e);
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

    private List<Widget> createWidgets(HudStagePrefab prefab, Table table, ResourceRegistry registry) {
        List<Widget> widgets = widgetFactory.createWidgets(prefab.getWidgetPrefabs(), table, registry);
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getTitleLabel()).expandX());
        table.row().padTop(20);
        widgets.forEach(w -> table.add(w.getValueLabel()).expandX());
        return widgets;
    }

    private StateBar createStateBar(HudStagePrefab prefab, Table table, ResourceRegistry registry, int colSpan) {
        StateBar stateBar = stateBarFactory.createStateBar(prefab.getStateBarPrefab(), registry);
        table.row().expandY();
        table.add(stateBar.getLabel()).colspan(colSpan);
        return stateBar;
    }

    private MessageBar createMessageBar(HudStagePrefab prefab, Table table, ResourceRegistry registry, int colSpan) {
        MessageBar messageBar = messageBarFactory.createMessageBar(prefab.getMessageBarPrefab(), registry);
        Table helperTable = new Table();
        helperTable.add(messageBar.getImage()).right().bottom().padRight(20);
        helperTable.row();
        helperTable.add(messageBar.getMessageLabel()).right().bottom().pad(20);
        table.row().expand().colspan(colSpan);
        table.add(helperTable).right().bottom().pad(20);
        return messageBar;
    }
}
