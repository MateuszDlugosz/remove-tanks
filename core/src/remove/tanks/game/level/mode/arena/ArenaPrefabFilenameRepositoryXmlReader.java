package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefabFilenameRepositoryXmlReader {
    private static final String ARENA_PREFAB_FILENAME_ELEMENT = "arenaPrefabFilename";

    private final XmlReader xmlReader;

    public ArenaPrefabFilenameRepositoryXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public ArenaPrefabFilenameRepository readArenaPrefabFilenameRepository(FileHandle fileHandle) {
        try {
            return new ArenaPrefabFilenameRepository(readArenaPrefabFilenames(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new ArenaPrefabFilenameRepositoryXmlReadException(fileHandle, e);
        }
    }

    private List<String> readArenaPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ARENA_PREFAB_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
