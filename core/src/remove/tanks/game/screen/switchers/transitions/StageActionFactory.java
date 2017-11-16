package remove.tanks.game.screen.switchers.transitions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author Mateusz Długosz
 */
public interface StageActionFactory {
    Action createStageAction(Stage stage);
}
