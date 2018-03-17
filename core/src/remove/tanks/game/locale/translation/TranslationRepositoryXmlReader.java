package remove.tanks.game.locale.translation;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TranslationRepositoryXmlReader {
    private static final String TRANSLATION_FILENAME_ELEMENT = "translationFilename";

    private static final String ID_ATTRIBUTE = "id";

    private final XmlReader xmlReader;

    public TranslationRepositoryXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public TranslationRepository readTranslationRepository(FileHandle fileHandle) {
        try {
            return new TranslationRepository(readTranslationFilenames(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new TranslationRepositoryXmlReadException(fileHandle.path(), e);
        }
    }

    private Map<String, String> readTranslationFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(TRANSLATION_FILENAME_ELEMENT).toArray())
                .collect(Collectors.toMap(
                        e -> e.getAttribute(ID_ATTRIBUTE),
                        e -> e.getText().trim()
                ));
    }
}
