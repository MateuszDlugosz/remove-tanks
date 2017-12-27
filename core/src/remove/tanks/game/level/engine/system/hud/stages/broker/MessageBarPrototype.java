package remove.tanks.game.level.engine.system.hud.stages.broker;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.FacePrototype;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinterPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrototype {
    private final String defaultMessage;
    private final MessagePrinterPrototype messagePrinterPrototype;
    private final List<FacePrototype> facePrototypes;

    public MessageBarPrototype(
            String defaultMessage,
            MessagePrinterPrototype messagePrinterPrototype,
            List<FacePrototype> facePrototypes
    ) {
        this.defaultMessage = defaultMessage;
        this.messagePrinterPrototype = messagePrinterPrototype;
        this.facePrototypes = facePrototypes;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public MessagePrinterPrototype getMessagePrinterPrototype() {
        return messagePrinterPrototype;
    }

    public List<FacePrototype> getFacePrototypes() {
        return facePrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("defaultMessage", defaultMessage)
                .add("messagePrinterPrototype", messagePrinterPrototype)
                .add("facePrototypes", facePrototypes)
                .toString();
    }
}
