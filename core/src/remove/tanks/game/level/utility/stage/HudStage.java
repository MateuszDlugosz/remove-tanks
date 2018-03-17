package remove.tanks.game.level.utility.stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.utility.stage.broker.MessageBar;
import remove.tanks.game.level.utility.stage.broker.message.Message;
import remove.tanks.game.level.utility.stage.state.StateBar;
import remove.tanks.game.level.utility.stage.widget.Widget;

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

    public void update(float delta, ResourceRegistry registry) {
        widgets.forEach(w -> w.update(delta, registry));
        stateBar.update();
        messageBar.update(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
