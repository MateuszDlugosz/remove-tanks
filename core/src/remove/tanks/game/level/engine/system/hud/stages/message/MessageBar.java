package remove.tanks.game.level.engine.system.hud.stages.message;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.locale.Locale;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class MessageBar {
    private final Label messageLabel;
    private final Locale locale;
    private final List<Message> messages;
    private final String defaultMessage;

    public MessageBar(
            Label messageLabel,
            Locale locale,
            String defaultMessage
    ) {
        this.messageLabel = messageLabel;
        this.locale = locale;
        this.messages = new ArrayList<>();
        this.defaultMessage = defaultMessage;
    }

    public Label getMessageLabel() {
        return messageLabel;
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
                messages.get(0).getTimer().update(delta);
                messageLabel.setText(locale.getTranslation().getEntry(messages.get(0).getEntryKey().getName())
                        .toUpperCase());
            } else {
                messages.remove(0);
            }
        } else {
            messageLabel.setText(defaultMessage);
        }
    }
}
