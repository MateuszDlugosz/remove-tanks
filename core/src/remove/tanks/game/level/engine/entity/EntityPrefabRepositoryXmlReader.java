package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabRepositoryXmlReader {
    private static final String ENTITY_PREFAB_FILENAME_ELEMENT = "entityPrefabFilename";
    private static final String ENTITY_PREFAB_FILENAMES_ELEMENT = "entityPrefabFilenames";

    private static final String CODE_ATTRIBUTE = "code";

    private final XmlReader xmlReader;

    public EntityPrefabRepositoryXmlReader(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    public EntityPrefabRepository readEntityPrefabFilenameRepository(FileHandle fileHandle) {
        try {
            return new EntityPrefabRepository(readEntityPrefabFilenames(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new EntityPrefabRepositoryXmlReadException(fileHandle.path(), e);
        }
    }

    private Map<String, String> readEntityPrefabFilenames(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ENTITY_PREFAB_FILENAME_ELEMENT).toArray())
                .collect(Collectors.toMap(
                        e -> e.getAttribute(CODE_ATTRIBUTE),
                        e -> e.getText().trim()
                ));
    }
}
