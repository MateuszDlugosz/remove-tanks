package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.assets.loaders.ShaderProgramLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ParametersFactoryTest {
    private ParametersFactory parametersFactory;
    private ParametersPrefab prefab0;
    private ParametersPrefab prefab1;

    @Before
    public void initTestObjects() {
        parametersFactory = new ParametersFactory(
                new SubParametersFactory[] {
                        new ParticleEffectParametersFactory()
                }
        );

        Map<String, String> parametersMap0 = new HashMap<>();
        parametersMap0.put("atlasFile", "sample-file");
        prefab0 = new ParametersPrefab(ParticleEffectLoader.ParticleEffectParameter.class,
                parametersMap0);

        Map<String, String> parametersMap1 = new HashMap<>();
        prefab1 = new ParametersPrefab(ShaderProgramLoader.ShaderProgramParameter.class,
                parametersMap1);
    }

    @Test
    public void Should_ReturnParameters() {
        AssetLoaderParameters parameters = parametersFactory.createAssetLoaderParameters(prefab0);
        ParticleEffectLoader.ParticleEffectParameter peParameters
                = (ParticleEffectLoader.ParticleEffectParameter) parameters;

        assertEquals(null, peParameters.atlasPrefix);
        assertEquals(null, peParameters.imagesDir);
        assertEquals("sample-file", peParameters.atlasFile);
    }

    @Test(expected = ParametersCreateException.class)
    public void Should_ThrowException_When_SubFactoryOfPrefabNotFound() {
        parametersFactory.createAssetLoaderParameters(prefab1);
    }
}
