package remove.tanks.game.level.engine.system.hud.stages.broker;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.Face;
import remove.tanks.game.level.engine.system.hud.stages.broker.message.Message;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class MessageBar {
    private final Label messageLabel;
    private final Image image;
    private final List<Message> messages;
    private final String defaultMessage;
    private final MessagePrinter messagePrinter;
    private final Map<String, Face> faces;

    public MessageBar(
            Label messageLabel,
            Image image,
            String defaultMessage,
            MessagePrinter messagePrinter,
            Map<String, Face> faces
    ) {
        this.messageLabel = messageLabel;
        this.messages = new ArrayList<>();
        this.defaultMessage = defaultMessage;
        this.messagePrinter = messagePrinter;
        this.faces = faces;
        this.image = image;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Image getImage() {
        return image;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void clearMessages() {
        messages.clear();
    }

    public void update(float delta) {
        if (messages.size() > 0) {
            if (!messages.get(0).getTimer().isCompleted()) {
                messages.get(0).getFaceId().ifPresent(id -> image.setDrawable(new SpriteDrawable(faces.get(id).getSprite())));

                if (messagePrinter.printMessage(messages.get(0), messageLabel, delta)) {
                    messages.get(0).getTimer().update(delta);

                    if (messages.get(0).getTimer().isCompleted()) {
                        messageLabel.setText(defaultMessage);
                        image.setDrawable(null);
                    }
                }
            } else {
                messages.remove(0);
            }
        }
    }
}
