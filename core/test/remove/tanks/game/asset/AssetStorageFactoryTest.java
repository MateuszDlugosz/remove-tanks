package remove.tanks.game.asset;

import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.ParticleEffectParametersFactory;
import remove.tanks.game.asset.parameter.RegistrableParametersFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class AssetStorageFactoryTest extends LibGDXTest {
    private AssetStorageFactory assetStorageFactory;

    @Before
    public void initTestObjects() {
        Map<Class<?>, AssetLoader> assetLoadersMap = new HashMap<>();
        assetStorageFactory = new AssetStorageFactory(
                new ParametersFactory(
                        new RegistrableParametersFactory[] {
                                new ParticleEffectParametersFactory()
                        }
                ),
                new AssetManagerFactory(
                        assetLoadersMap
                )
        );
    }

    @Test
    public void when_PassCorrectAssetPrototypesToFactory_Then_CreateAssetStorage() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype(
                "testId0", TextureAtlas.class,
                "graphic/textures/atlases/test-atlas-file.pack", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);

        assertEquals(TextureAtlas.class, assetStorage.getAsset("testId0", TextureAtlas.class).getClass());
    }

    @Test(expected = AssetStorageCreateException.class)
    public void when_PassIncorrectAssetPrototypesToFactory_Then_ThrowException() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype(
                "testId0", TextureAtlas.class,
                "graphic/textures/atlases/test-atlas-fil.pack", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);
    }

    @Test(expected = AssetStorageCreateException.class)
    public void when_PassAssetPrototypesWithTwiceIdToFactory_Then_ThrowException() {
        List<AssetPrototype> assetPrototypes = new ArrayList<>();
        assetPrototypes.add(new AssetPrototype(
                "testId0", TextureAtlas.class,
                "graphic/textures/atlases/test-atlas-file.pack", null));
        assetPrototypes.add(new AssetPrototype(
                "testId0", TextureAtlas.class,
                "graphic/textures/atlases/test-atlas-file.pack", null));
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(assetPrototypes);
    }
}