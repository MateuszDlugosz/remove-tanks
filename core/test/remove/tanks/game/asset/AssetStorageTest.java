package remove.tanks.game.asset;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.ParticleEffectParametersFactory;
import remove.tanks.game.asset.parameter.RegistrableParametersFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Mateusz Długosz
 */
public class AssetStorageTest {
    private AssetStorageFactory assetStorageFactory;

    @Before
    public void initTestObjects() {
        assetStorageFactory = new AssetStorageFactory(
                new ParametersFactory(
                        new RegistrableParametersFactory[] {
                                new ParticleEffectParametersFactory()
                        }
                ),
                new AssetManagerFactory(
                        new HashMap<>()
                )
        );
    }

    @Test(expected = AssetIdNotExistsException.class)
    public void when_AssetIdIsNotExists_Then_ThrowException() {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(new ArrayList<>());
        assetStorage.getAsset("testId0", TextureAtlas.class);
    }
}