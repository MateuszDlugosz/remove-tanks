package remove.tanks.game.level.engine.system.hud.stages.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrototypeXmlLoader {
    public static final String MESSAGE_ELEMENT = "message";

    private static final String TIME_ELEMENT = "time";
    private static final String ENTRY_KEY_ELEMENT = "entryKey";

    public MessagePrototype loadMessagePrototype(XmlReader.Element element) {
        try {
            return new MessagePrototype(
                    loadTime(element),
                    loadEntryKey(element)
            );
        } catch (Exception e) {
            throw new MessagePrototypeXmlLoadException(element, e);
        }
    }

    private float loadTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private TranslationEntryKey loadEntryKey(XmlReader.Element element) {
        return TranslationEntryKey.valueOf(element.getChildByName(ENTRY_KEY_ELEMENT).getText().trim());
    }
}
