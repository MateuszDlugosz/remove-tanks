package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReader;
import remove.tanks.game.level.preload.PreloadData;
import remove.tanks.game.level.preload.PreloadDataXmlReader;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabXmlReader {
    private final XmlReader xmlReader;
    private final PreloadDataXmlReader preloadDataXmlReader;
    private final ComponentPrefabXmlReader componentPrefabXmlReader;

    public EntityPrefabXmlReader(
            XmlReader xmlReader,
            PreloadDataXmlReader preloadDataXmlReader,
            ComponentPrefabXmlReader componentPrefabXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.preloadDataXmlReader = preloadDataXmlReader;
        this.componentPrefabXmlReader = componentPrefabXmlReader;
    }

    public EntityPrefab readEntityPrefab(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new EntityPrefab(
                    readPreloadData(element),
                    readComponents(element)
            );
        } catch (Exception e) {
            throw new EntityPrefabXmlReadException(fileHandle.path(), e);
        }
    }

    private PreloadData readPreloadData(XmlReader.Element element) {
        if (element.getChildByName(PreloadDataXmlReader.PRELOAD_DATA_ELEMENT) == null) {
            return new PreloadData(new ArrayList<>(), new ArrayList<>());
        }
        return preloadDataXmlReader.readPreloadData(element.getChildByName(PreloadDataXmlReader.PRELOAD_DATA_ELEMENT));
    }

    private Map<Class<? extends ComponentPrefab>, ComponentPrefab> readComponents(XmlReader.Element element) {
        return componentPrefabXmlReader.readComponentsPrefabs(
                element.getChildByName(ComponentPrefabXmlReader.COMPONENTS_ELEMENT)
        ).stream().collect(Collectors.toMap(ComponentPrefab::getClass, c -> c));
    }
}
