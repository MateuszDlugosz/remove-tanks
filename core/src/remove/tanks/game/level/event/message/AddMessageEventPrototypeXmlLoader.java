package remove.tanks.game.level.event.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.hud.stages.message.MessagePrototype;
import remove.tanks.game.level.engine.system.hud.stages.message.MessagePrototypeXmlLoader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<AddMessageEventPrototype>
{
    private final MessagePrototypeXmlLoader messagePrototypeXmlLoader;

    public AddMessageEventPrototypeXmlLoader(MessagePrototypeXmlLoader messagePrototypeXmlLoader) {
        this.messagePrototypeXmlLoader = messagePrototypeXmlLoader;
    }

    @Override
    public AddMessageEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new AddMessageEventPrototype(
                    loadMessagePrototype(element)
            );
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    private MessagePrototype loadMessagePrototype(XmlReader.Element element) {
        return messagePrototypeXmlLoader.loadMessagePrototype(
                element.getChildByName(MessagePrototypeXmlLoader.MESSAGE_ELEMENT)
        );
    }

    @Override
    public EventType getLoaderType() {
        return EventType.AddMessageEvent;
    }
}
