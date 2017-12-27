package remove.tanks.game.level.engine.system.hud.stages.message;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarFactory {
    public MessageBar createMessageBar(MessageBarPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new MessageBar(
                    createMessageLabel(prototype, resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)),
                    resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                    prototype.getDefaultMessage()
            );
        } catch (Exception e) {
            throw new MessageBarCreateException(prototype, e);
        }
    }

    private Label createMessageLabel(MessageBarPrototype prototype, Skin skin) {
        return new Label(prototype.getDefaultMessage(), skin);
    }
}
