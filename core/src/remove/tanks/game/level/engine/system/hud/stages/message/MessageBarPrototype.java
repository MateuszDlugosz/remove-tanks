package remove.tanks.game.level.engine.system.hud.stages.message;

import com.google.common.base.MoreObjects;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrototype {
    private final String defaultMessage;

    public MessageBarPrototype(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("defaultMessage", defaultMessage)
                .toString();
    }
}
