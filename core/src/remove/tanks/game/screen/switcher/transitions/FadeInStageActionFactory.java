package remove.tanks.game.screen.switcher.transitions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * @author Mateusz Długosz
 */
public final class FadeInStageActionFactory implements StageActionFactory {
    private final float duration;

    public FadeInStageActionFactory(float duration) {
        this.duration = duration;
    }

    @Override
    public Action createStageAction(Stage stage) {
        stage.getRoot().getColor().a = 0f;
        return Actions.fadeIn(duration);
    }
}
