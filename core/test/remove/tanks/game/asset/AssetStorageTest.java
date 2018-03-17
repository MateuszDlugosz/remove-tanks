package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.SubParametersFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mateusz Długosz
 */
public class AssetStorageTest extends LibGDXTest {
    private AssetStorage assetStorage;

    @Before
    public void initTestObjects() {
        Map<String, AssetPrefab> prefabsMap = new HashMap<>();
        prefabsMap.put("test-prefab-0", new AssetPrefab("test-prefab-0",
                "graphics/textures/atlases/test-atlas-file.png", Texture.class, null));
        prefabsMap.put("test-prefab-1", new AssetPrefab("test-prefab-1",
                "audio/music/test-music-0.ogg", Music.class, null));

        assetStorage = new AssetStorage(
                new AssetManager(),
                new AssetPrefabRepository(prefabsMap),
                new ParametersFactory(
                        new SubParametersFactory[] {}
                )
        );
    }

    @Test
    public void Should_ReturnAsset_When_AssetIsLoaded() {
        assetStorage.loadAsset("test-prefab-0");

        assertEquals(Texture.class, assetStorage.getAsset("test-prefab-0", Texture.class).getClass());
    }

    @Test(expected = AssetPrefabNotFoundException.class)
    public void Should_ThrowException_When_AssetPrefabNotFound() {
        assetStorage.getAsset("test-prefab-0-unknown", Texture.class);
    }

    @Test(expected = AssetIncompatibleClassException.class)
    public void Should_ThrowException_When_AssetIsIncompatibleTypeLoaded() {
        assetStorage.loadAsset("test-prefab-0");
        assetStorage.getAsset("test-prefab-0", TextureAtlas.class);
    }

    @Test(expected = AssetLoadException.class)
    public void Should_ThrowException_When_AssetPrefabIdNotFoundInRepository() {
        assetStorage.loadAsset("unknown-asset-id");
    }

    @Test
    public void Should_ReturnAsset_When_ArrayIsPassedToLoad() {
        assetStorage.loadAssets(new String[] {
                "test-prefab-0",
                "test-prefab-1"
        });

        assertNotNull(assetStorage.getAsset("test-prefab-0", Texture.class).getClass());
        assertNotNull(assetStorage.getAsset("test-prefab-1", Music.class).getClass());
    }

    @Test
    public void Should_ReturnAsset_When_ListIsPassedToLoad() {
        List<String> ids = new ArrayList<>();
        ids.add("test-prefab-0");
        ids.add("test-prefab-1");

        assetStorage.loadAssets(ids);

        assertNotNull(assetStorage.getAsset("test-prefab-0", Texture.class).getClass());
        assertNotNull(assetStorage.getAsset("test-prefab-1", Music.class).getClass());
    }

    @Test(expected = AssetLoadException.class)
    public void Should_ThrowException_When_ArrayIsPassedToLoadWithUnknownId() {
        assetStorage.loadAssets(new String[] {
                "test-prefab-0",
                "test-prefab-2"
        });
    }

    @Test(expected = AssetLoadException.class)
    public void Should_ThrowException_When_ListIsPassedToLoadWithUnknownId() {
        List<String> ids = new ArrayList<>();
        ids.add("test-prefab-0");
        ids.add("test-prefab-2");
        assetStorage.loadAssets(ids);
    }
}