package remove.tanks.game.level.utility.stage.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface Widget {
    Label getTitleLabel();
    Label getValueLabel();
    void update(float delta, ResourceRegistry registry);
}
