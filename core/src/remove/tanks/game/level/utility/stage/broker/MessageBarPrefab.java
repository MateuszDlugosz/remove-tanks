package remove.tanks.game.level.utility.stage.broker;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.utility.stage.broker.face.FacePrefab;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrefab extends Prefab {
    private final String defaultMessage;
    private final MessagePrinterPrefab messagePrinterPrefab;
    private final List<FacePrefab> facePrefabs;

    public MessageBarPrefab(
            String defaultMessage,
            MessagePrinterPrefab messagePrinterPrefab,
            List<FacePrefab> facePrefabs
    ) {
        this.defaultMessage = defaultMessage;
        this.messagePrinterPrefab = messagePrinterPrefab;
        this.facePrefabs = facePrefabs;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public MessagePrinterPrefab getMessagePrinterPrefab() {
        return messagePrinterPrefab;
    }

    public List<FacePrefab> getFacePrefabs() {
        return facePrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("defaultMessage", defaultMessage)
                .add("messagePrinterPrefab", messagePrinterPrefab)
                .add("facePrefabs", facePrefabs)
                .toString();
    }
}
