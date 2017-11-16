package remove.tanks.game.locale.translation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TranslationXmlLoader {
    private static final String ID_ATTRIBUTE = "id";
    private static final String ENTRY_ELEMENT = "entry";
    private static final String KEY_ATTRIBUTE = "key";

    private final XmlReader xmlReader;

    public TranslationXmlLoader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public Translation loadTranslation(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new Translation(
                    element.getAttribute(ID_ATTRIBUTE).trim(),
                    Arrays.stream(element.getChildrenByName(ENTRY_ELEMENT).toArray())
                            .collect(Collectors.toMap(
                                    e -> e.getAttribute(KEY_ATTRIBUTE).trim(),
                                    XmlReader.Element::getText
                            ))
            );
        } catch (Exception e) {
            throw new TranslationXmlLoadException(filename, e);
        }
    }
}
