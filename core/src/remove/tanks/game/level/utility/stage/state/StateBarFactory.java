package remove.tanks.game.level.utility.stage.state;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class StateBarFactory {
    public StateBar createStateBar(StateBarPrefab prefab, ResourceRegistry registry) {
        try {
            return new StateBar(
                    createLabel(
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    ),
                    prefab.getDisplayableStates(),
                    registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                    registry.getResource(ResourceType.LocaleResource, Locale.class)
            );
        } catch (Exception e) {
            throw new StateBarCreateException(prefab, e);
        }
    }

    private Label createLabel(Skin skin) {
        return new Label("", skin);
    }
}
