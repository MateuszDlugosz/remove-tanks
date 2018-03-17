package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class AssetIdXmlReaderTest {
    private static final String ASSET_ID_CORRECT_ELEMENT =
            "<assetId>test-id</assetId>";

    private static final String ASSET_ID_INCORRECT_ELEMENT =
            "<assetId></assetId>";

    private static final String ASSET_IDS_CORRECT_ELEMENT =
            "<assetIds>" +
                    "<assetId>test-id-0</assetId>" +
                    "<assetId>test-id-1</assetId>" +
            "</assetIds>";

    private static final String ASSET_IDS_INCORRECT_ELEMENT =
            "<assetIds>" +
                    "<assetId>test-id-0</assetId>" +
                    "<assetId></assetId>" +
            "</assetIds>";

    private XmlReader xmlReader;
    private AssetIdXmlReader assetIdXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        assetIdXmlReader = new AssetIdXmlReader();
    }

    @Test
    public void Should_ReturnAssetId() {
        assertEquals("test-id", assetIdXmlReader.readAssetId(xmlReader.parse(ASSET_ID_CORRECT_ELEMENT)));
    }

    @Test(expected = AssetIdXmlReadException.class)
    public void Should_ThrowException_When_AssetIdElementIsEmpty() {
        assetIdXmlReader.readAssetId(xmlReader.parse(ASSET_ID_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnAssetIds() {
        List<String> ids = assetIdXmlReader.readAssetIds(xmlReader.parse(ASSET_IDS_CORRECT_ELEMENT));

        assertEquals(2, ids.size());
        assertEquals("test-id-0", ids.get(0));
        assertEquals("test-id-1", ids.get(1));
    }

    @Test(expected = AssetIdXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneAssetIdElementIsEmpty() {
        assetIdXmlReader.readAssetIds(xmlReader.parse(ASSET_IDS_INCORRECT_ELEMENT));
    }
}