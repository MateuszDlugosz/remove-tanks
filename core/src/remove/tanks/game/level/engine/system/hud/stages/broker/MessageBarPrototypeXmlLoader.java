package remove.tanks.game.level.engine.system.hud.stages.broker;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.FacePrototype;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.FacePrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinterPrototype;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinterPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrototypeXmlLoader {
    public static final String  MESSAGE_BAR_ELEMENT = "messageBar";

    private static final String DEFAULT_MESSAGE_ELEMENT = "defaultMessage";

    private final MessagePrinterPrototypeXmlLoader messagePrinterPrototypeXmlLoader;
    private final FacePrototypeXmlLoader facePrototypeXmlLoader;

    public MessageBarPrototypeXmlLoader(
            MessagePrinterPrototypeXmlLoader messagePrinterPrototypeXmlLoader,
            FacePrototypeXmlLoader facePrototypeXmlLoader
    ) {
        this.messagePrinterPrototypeXmlLoader = messagePrinterPrototypeXmlLoader;
        this.facePrototypeXmlLoader = facePrototypeXmlLoader;
    }

    public MessageBarPrototype loadMessageBarPrototype(XmlReader.Element element) {
        try {
            return new MessageBarPrototype(
                    loadDefaultMessage(element),
                    loadMessagePrinterPrototype(element),
                    loadFacePrototypes(element)
            );
        } catch (Exception e) {
            throw new MessageBarPrototypeXmlLoadException(element, e);
        }
    }

    private String loadDefaultMessage(XmlReader.Element element) {
        return element.getChildByName(DEFAULT_MESSAGE_ELEMENT).getText();
    }

    private MessagePrinterPrototype loadMessagePrinterPrototype(XmlReader.Element element) {
        return messagePrinterPrototypeXmlLoader.loadMessagePrinterPrototype(
                element.getChildByName(MessagePrinterPrototypeXmlLoader.MESSAGE_PRINTER_ELEMENT)
        );
    }

    private List<FacePrototype> loadFacePrototypes(XmlReader.Element element) {
        return facePrototypeXmlLoader.loadFacePrototypes(
                element.getChildByName(FacePrototypeXmlLoader.FACES_ELEMENT)
        );
    }
}
