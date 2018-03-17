package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AssetIdXmlReader {
    public static final String ASSET_ID_ELEMENT = "assetId";
    public static final String ASSET_IDS_ELEMENT = "assetIds";

    public List<String> readAssetIds(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ASSET_ID_ELEMENT).toArray())
                .map(this::readAssetId)
                .collect(Collectors.toList());
    }

    public String readAssetId(XmlReader.Element element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            throw new AssetIdXmlReadException(element, e);
        }
    }
}
