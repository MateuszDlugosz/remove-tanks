package remove.tanks.game.level.engine.system.hud.stages;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import remove.tanks.game.level.engine.system.hud.stages.broker.MessageBar;
import remove.tanks.game.level.engine.system.hud.stages.broker.message.Message;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBar;
import remove.tanks.game.level.engine.system.hud.stages.widget.Widget;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStage implements Disposable {
    private final Stage stage;
    private final List<Widget> widgets;
    private final StateBar stateBar;
    private final MessageBar messageBar;

    public HudStage(Stage stage, List<Widget> widgets, StateBar stateBar, MessageBar messageBar) {
        this.stage = stage;
        this.widgets = widgets;
        this.stateBar = stateBar;
        this.messageBar = messageBar;
    }

    public Stage getStage() {
        return stage;
    }

    public void addMessage(Message message) {
        messageBar.addMessage(message);
    }

    public void clearMessages() {
        messageBar.clearMessages();
    }

    public void update(float delta, ResourceRegistry resourceRegistry) {
        widgets.forEach(w -> w.update(delta, resourceRegistry));
        stateBar.update();
        messageBar.update(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
