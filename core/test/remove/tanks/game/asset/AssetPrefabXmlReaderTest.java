package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.asset.parameter.ParametersPrefabXmlReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class AssetPrefabXmlReaderTest {
    private static final String ASSET_PREFAB_CORRECT_ELEMENT =
            "<asset id=\"test-id\">" +
                    "<assetClass>remove.tanks.game.asset.AssetPrefabXmlReaderTest</assetClass>" +
                    "<filename>test/filename</filename>" +
            "</asset>";

    private static final String ASSET_PREFAB_INCORRECT_ELEMENT =
            "<asset id=\"test-id\">" +
                    "<filename>test/filename</filename>" +
            "</asset>";

    private static final String ASSET_PREFABS_CORRECT_ELEMENT =
            "<assets >" +
                    "<asset id=\"test-id-0\">" +
                    "   <assetClass>remove.tanks.game.asset.AssetPrefabXmlReaderTest</assetClass>" +
                    "   <filename>test/filename0</filename>" +
                    "</asset>" +
                    "<asset id=\"test-id-1\">" +
                    "   <assetClass>remove.tanks.game.asset.AssetPrefabXmlReaderTest</assetClass>" +
                    "   <filename>test/filename1</filename>" +
                    "</asset>" +
            "</assets>";

    private static final String ASSET_PREFABS_INCORRECT_ELEMENT =
            "<assets >" +
                    "<asset id=\"test-id-0\">" +
                    "   <assetClass>ancient.sun.game.asset.AssetPrefabXmlReaderTest</assetClass>" +
                    "   <filename>test/filename0</filename>" +
                    "</asset>" +
                    "<asset></asset>" +
            "</assets>";

    private XmlReader xmlReader;
    private AssetPrefabXmlReader assetPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        assetPrefabXmlReader = new AssetPrefabXmlReader(new ParametersPrefabXmlReader());
    }

    @Test
    public void Should_ReturnAssetPrefab() {
        AssetPrefab prefab = assetPrefabXmlReader.readAssetPrefab(xmlReader.parse(ASSET_PREFAB_CORRECT_ELEMENT));

        assertEquals(AssetPrefabXmlReaderTest.class, prefab.getAssetClass());
        assertEquals("test/filename", prefab.getFilename());
        assertEquals("test-id", prefab.getId());
    }

    @Test(expected = AssetPrefabXmlReadException.class)
    public void Should_ThrowException_When_AssetPrefabElementIsIncorrectlyFormatted() {
        assetPrefabXmlReader.readAssetPrefab(xmlReader.parse(ASSET_PREFAB_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnAssetPrefabs() {
        assertEquals(2, assetPrefabXmlReader.readAssetPrefabs(xmlReader.parse(ASSET_PREFABS_CORRECT_ELEMENT)).size());
    }

    @Test(expected = AssetPrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneAssetPrefabElementIsIncorrectlyFormatted() {
        assetPrefabXmlReader.readAssetPrefab(xmlReader.parse(ASSET_PREFABS_INCORRECT_ELEMENT));
    }
}