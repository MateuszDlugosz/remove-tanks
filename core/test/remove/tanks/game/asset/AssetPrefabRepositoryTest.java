package remove.tanks.game.asset;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class AssetPrefabRepositoryTest {
    private AssetPrefabRepository assetPrefabRepository;

    @Before
    public void initTestObjects() {
        Map<String, AssetPrefab> assetPrefabs = new HashMap<>();
        assetPrefabs.put("test-id", new AssetPrefab("test-id", "test-filename",
                AssetPrefabRepositoryTest.class, null));

        assetPrefabRepository = new AssetPrefabRepository(assetPrefabs);
    }

    @Test
    public void Should_ReturnAssetPrefab() {
        assertEquals("test-id", assetPrefabRepository.getAssetPrefab("test-id").getId());
    }

    @Test(expected = AssetPrefabNotFoundException.class)
    public void Should_ThrowException_When_AssetPrefabNotFound() {
        assetPrefabRepository.getAssetPrefab("unknown-id");
    }
}