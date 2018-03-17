package remove.tanks.game.asset;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Mateusz Długosz
 */
public class AssetPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        AssetPrefab prefab = new AssetPrefab("test-id","test-filename", AssetPrefabTest.class,null);

        assertEquals("test-id", prefab.getId());
        assertEquals("test-filename", prefab.getFilename());
        assertEquals(AssetPrefabTest.class, prefab.getAssetClass());
        assertFalse(prefab.getParametersPrefab().isPresent());
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        assertEquals("AssetPrefab{id=test-id, filename=test-filename, " +
                "assetClass=class remove.tanks.game.asset.AssetPrefabTest, parametersPrefab=null}",
                new AssetPrefab("test-id","test-filename",
                        AssetPrefabTest.class,null).toString()
        );
    }
}