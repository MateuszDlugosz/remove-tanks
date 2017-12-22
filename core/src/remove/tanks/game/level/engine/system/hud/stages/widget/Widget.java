package remove.tanks.game.level.engine.system.hud.stages.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public interface Widget {
    Label getTitleLabel();
    Label getValueLabel();
    void update(float delta, ResourceRegistry resourceRegistry);
}
