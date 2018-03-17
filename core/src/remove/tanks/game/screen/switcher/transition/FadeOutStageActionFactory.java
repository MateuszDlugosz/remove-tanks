package remove.tanks.game.screen.switcher.transition;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * @author Mateusz Długosz
 */
public final class FadeOutStageActionFactory implements StageActionFactory {
    private final float duration;

    public FadeOutStageActionFactory(float duration) {
        this.duration = duration;
    }

    @Override
    public Action createStageAction(Stage stage) {
        return Actions.fadeOut(duration);
    }
}
