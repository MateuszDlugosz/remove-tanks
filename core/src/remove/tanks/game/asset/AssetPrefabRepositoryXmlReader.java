package remove.tanks.game.asset;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefabRepositoryXmlReader {
    private final XmlReader xmlReader;
    private final AssetPrefabXmlReader assetPrefabXmlReader;

    public AssetPrefabRepositoryXmlReader(XmlReader xmlReader, AssetPrefabXmlReader assetPrefabXmlReader) {
        this.xmlReader = xmlReader;
        this.assetPrefabXmlReader = assetPrefabXmlReader;
    }

    public AssetPrefabRepository readAssetPrefabRepository(FileHandle fileHandle) {
        try {
            return new AssetPrefabRepository(readAssetPrefabs(xmlReader.parse(fileHandle)));
        } catch (Exception e) {
            throw new AssetPrefabRepositoryXmlReadException(fileHandle.path(), e);
        }
    }

    private Map<String, AssetPrefab> readAssetPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(AssetPrefabXmlReader.ASSET_ELEMENT).toArray())
                .map(assetPrefabXmlReader::readAssetPrefab)
                .collect(Collectors.toMap(
                        AssetPrefab::getId,
                        p -> p
                ));
    }
}
