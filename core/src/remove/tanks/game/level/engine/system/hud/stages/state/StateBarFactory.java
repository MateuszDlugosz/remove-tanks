package remove.tanks.game.level.engine.system.hud.stages.state;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class StateBarFactory {
    public StateBar createStateBar(StateBarPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new StateBar(
                    createLabel(
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    ),
                    prototype.getDisplayableStates(),
                    resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                    resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class)
            );
        } catch (Exception e) {
            throw new StateBarCreateException(prototype, e);
        }
    }

    private Label createLabel(Skin skin) {
        return new Label("", skin);
    }
}
