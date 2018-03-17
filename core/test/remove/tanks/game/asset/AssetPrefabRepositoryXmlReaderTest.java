package remove.tanks.game.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.parameter.ParametersPrefabXmlReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class AssetPrefabRepositoryXmlReaderTest extends LibGDXTest {
    private static final String ASSET_PREFAB_REPOSITORY_CORRECT_FILE = "asset-prefab-test-repository-correct.xml";
    private static final String ASSET_PREFAB_REPOSITORY_INCORRECT_FILE = "asset-prefab-test-repository-incorrect.xml";

    private AssetPrefabRepositoryXmlReader assetPrefabRepositoryXmlReader;

    @Before
    public void initTestObjects() {
        assetPrefabRepositoryXmlReader = new AssetPrefabRepositoryXmlReader(
                new XmlReader(),
                new AssetPrefabXmlReader(
                        new ParametersPrefabXmlReader()
                )
        );
    }

    @Test
    public void Should_ReturnAssetPrefabRepository() {
        assertEquals(
                String.class,
                assetPrefabRepositoryXmlReader.readAssetPrefabRepository(
                        Gdx.files.internal(ASSET_PREFAB_REPOSITORY_CORRECT_FILE))
                        .getAssetPrefab("test-string").getAssetClass()
        );
    }

    @Test(expected = AssetPrefabRepositoryXmlReadException.class)
    public void Should_ThrowException_When_RepositoryFileIsIncorrectlyFormatted() {
        assetPrefabRepositoryXmlReader.readAssetPrefabRepository(
                Gdx.files.internal(ASSET_PREFAB_REPOSITORY_INCORRECT_FILE));
    }
}