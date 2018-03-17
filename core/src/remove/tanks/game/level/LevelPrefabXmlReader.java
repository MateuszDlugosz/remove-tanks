package remove.tanks.game.level;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.EnginePrefab;
import remove.tanks.game.level.engine.EnginePrefabXmlReader;
import remove.tanks.game.level.preload.PreloadData;
import remove.tanks.game.level.preload.PreloadDataXmlReader;
import remove.tanks.game.level.resource.configuration.ResourceConfigurations;
import remove.tanks.game.level.resource.configuration.ResourceConfigurationsXmlReader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrefabXmlReader {
    private static final String TILED_MAP_FILENAME_ELEMENT = "tiledMapFilename";
    private static final String ENTITY_PREFAB_REPOSITORY_FILENAME = "entityPrefabRepositoryFilename";
    private static final String ASSET_PREFAB_REPOSITORY_FILENAME = "assetPrefabRepositoryFilename";

    private final XmlReader xmlReader;
    private final PreloadDataXmlReader preloadDataXmlReader;
    private final ResourceConfigurationsXmlReader resourceConfigurationsXmlReader;
    private final EnginePrefabXmlReader enginePrefabXmlReader;

    public LevelPrefabXmlReader(
            XmlReader xmlReader,
            PreloadDataXmlReader preloadDataXmlReader,
            ResourceConfigurationsXmlReader resourceConfigurationsXmlReader,
            EnginePrefabXmlReader enginePrefabXmlReader
    ) {
        this.xmlReader = xmlReader;
        this.preloadDataXmlReader = preloadDataXmlReader;
        this.resourceConfigurationsXmlReader = resourceConfigurationsXmlReader;
        this.enginePrefabXmlReader = enginePrefabXmlReader;
    }

    public List<LevelPrefab> readLevelPrefabs(List<FileHandle> fileHandles) {
        return fileHandles.stream()
                .map(this::readLevelPrefab)
                .collect(Collectors.toList());
    }

    public LevelPrefab readLevelPrefab(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new LevelPrefab(
                    readPreloadData(element),
                    readResourceConfigurations(element),
                    readTiledMapFilename(element),
                    readEntityPrefabRepositoryFilename(element),
                    readAssetPrefabRepositoryFilename(element),
                    readEnginePrefab(element)
            );
        } catch (Exception e) {
            throw new LevelPrefabXmlReadException(fileHandle.path(), e);
        }
    }

    private PreloadData readPreloadData(XmlReader.Element element) {
        return preloadDataXmlReader.readPreloadData(element.getChildByName(PreloadDataXmlReader.PRELOAD_DATA_ELEMENT));
    }

    private ResourceConfigurations readResourceConfigurations(XmlReader.Element element) {
        return resourceConfigurationsXmlReader.readResourceConfiguration(
                element.getChildByName(ResourceConfigurationsXmlReader.RESOURCE_CONFIGURATIONS_ELEMENT));
    }

    private String readTiledMapFilename(XmlReader.Element element) {
        return element.getChildByName(TILED_MAP_FILENAME_ELEMENT).getText().trim();
    }

    private String readEntityPrefabRepositoryFilename(XmlReader.Element element) {
        return element.getChildByName(ENTITY_PREFAB_REPOSITORY_FILENAME).getText().trim();
    }

    private String readAssetPrefabRepositoryFilename(XmlReader.Element element) {
        return element.getChildByName(ASSET_PREFAB_REPOSITORY_FILENAME).getText().trim();
    }

    private EnginePrefab readEnginePrefab(XmlReader.Element element) {
        return enginePrefabXmlReader.readEnginePrefab(element.getChildByName(EnginePrefabXmlReader.ENGINE_ELEMENT));
    }
}
