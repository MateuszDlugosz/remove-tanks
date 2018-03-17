package remove.tanks.game.locale.translation;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TranslationXmlReader {
    public static final String TRANSLATION_FILENAME_ELEMENT = "translationFilename";
    public static final String TRANSLATION_FILENAMES_ELEMENT = "translationFilenames";

    private static final String ENTRY_ELEMENT = "entry";
    private static final String KEY_ATTRIBUTE = "key";

    private final XmlReader xmlReader;

    public TranslationXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public Translation readTranslation(FileHandle fileHandle) {
        try {
            return new Translation(readEntries(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new TranslationXmlReadException(fileHandle.path(), e);
        }
    }

    private Map<String, String> readEntries(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ENTRY_ELEMENT).toArray())
                .collect(Collectors.toMap(
                        e -> e.getAttribute(KEY_ATTRIBUTE).trim(),
                        XmlReader.Element::getText
                ));
    }
}
