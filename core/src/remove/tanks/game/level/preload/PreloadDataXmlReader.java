package remove.tanks.game.level.preload;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.asset.AssetIdXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PreloadDataXmlReader {
    public static final String PRELOAD_DATA_ELEMENT = "preloadData";

    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;
    private final AssetIdXmlReader assetIdXmlReader;

    public PreloadDataXmlReader(EntityPrefabCodeXmlReader entityPrefabCodeXmlReader, AssetIdXmlReader assetIdXmlReader) {
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
        this.assetIdXmlReader = assetIdXmlReader;
    }

    public PreloadData readPreloadData(XmlReader.Element element) {
        try {
            return new PreloadData(
                    readEntityPrefabCodes(element),
                    readAssetIds(element)
            );
        } catch (Exception e) {
            throw new PreloadDataXmlReadException(element, e);
        }
    }

    private List<String> readEntityPrefabCodes(XmlReader.Element element) {
        if (element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODES_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return entityPrefabCodeXmlReader.readEntityPrefabCodes(
                element.getChildByName(EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODES_ELEMENT)
        );
    }

    private List<String> readAssetIds(XmlReader.Element element) {
        if (element.getChildByName(AssetIdXmlReader.ASSET_IDS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return assetIdXmlReader.readAssetIds(
                element.getChildByName(AssetIdXmlReader.ASSET_IDS_ELEMENT)
        );
    }
}
