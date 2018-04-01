package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class OperationPrefabFilenameRepositoryXmlReader {
    private static final String OPERATION_PREFAB_FILENAME_ELEMENT = "operationPrefabFilename";

    private final XmlReader xmlReader;

    public OperationPrefabFilenameRepositoryXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public OperationPrefabFilenameRepository readOperationPrefabFilenameRepository(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new OperationPrefabFilenameRepository(
                    readOperationPrefabFilenames(element)
            );
        } catch (Exception e) {
            throw new OperationPrefabFilenameRepositoryXmlReadException(fileHandle, e);
        }
    }

    private List<String> readOperationPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(OPERATION_PREFAB_FILENAME_ELEMENT).toArray())
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
