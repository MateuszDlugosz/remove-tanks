package remove.tanks.game.level.utility.stage.broker;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.utility.stage.broker.face.FacePrefab;
import remove.tanks.game.level.utility.stage.broker.face.FacePrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterPrefab;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrefabXmlReader {
    public static final String  MESSAGE_BAR_ELEMENT = "messageBar";

    private static final String DEFAULT_MESSAGE_ELEMENT = "defaultMessage";

    private final MessagePrinterPrefabXmlReader messagePrinterPrefabXmlReader;
    private final FacePrefabXmlReader facePrefabXmlReader;

    public MessageBarPrefabXmlReader(
            MessagePrinterPrefabXmlReader messagePrinterPrefabXmlReader,
            FacePrefabXmlReader facePrefabXmlReader
    ) {
        this.messagePrinterPrefabXmlReader = messagePrinterPrefabXmlReader;
        this.facePrefabXmlReader = facePrefabXmlReader;
    }

    public MessageBarPrefab readMessageBarPrefab(XmlReader.Element element) {
        try {
            return new MessageBarPrefab(
                    readDefaultMessage(element),
                    readMessagePrinterPrefab(element),
                    readFacePrefabs(element)
            );
        } catch (Exception e) {
            throw new MessageBarPrefabXmlReadException(element, e);
        }
    }

    private String readDefaultMessage(XmlReader.Element element) {
        return element.getChildByName(DEFAULT_MESSAGE_ELEMENT).getText();
    }

    private MessagePrinterPrefab readMessagePrinterPrefab(XmlReader.Element element) {
        return messagePrinterPrefabXmlReader.readMessagePrinterPrefab(
                element.getChildByName(MessagePrinterPrefabXmlReader.MESSAGE_PRINTER_ELEMENT)
        );
    }

    private List<FacePrefab> readFacePrefabs(XmlReader.Element element) {
        return facePrefabXmlReader.readFacePrefabs(
                element.getChildByName(FacePrefabXmlReader.FACES_ELEMENT)
        );
    }
}
