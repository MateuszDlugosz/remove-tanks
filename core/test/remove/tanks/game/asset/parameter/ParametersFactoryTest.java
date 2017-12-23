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
    private ParametersPrototype prototype0;
    private ParametersPrototype prototype1;

    @Before
    public void initTestObjects() {
        parametersFactory = new ParametersFactory();
        parametersFactory.registerFactory(new ParticleEffectParametersFactory());

        Map<String, String> parametersMap0 = new HashMap<>();
        parametersMap0.put("atlasFile", "sample-file");
        prototype0 = new ParametersPrototype(ParticleEffectLoader.ParticleEffectParameter.class,
                parametersMap0);

        Map<String, String> parametersMap1 = new HashMap<>();
        prototype1 = new ParametersPrototype(ShaderProgramLoader.ShaderProgramParameter.class,
                parametersMap1);
    }

    @Test
    public void when_ParametersFactoryFound_Then_LoadParameters() {
        AssetLoaderParameters parameters = parametersFactory.createAssetLoaderParameters(prototype0);
        ParticleEffectLoader.ParticleEffectParameter peParameters
                = (ParticleEffectLoader.ParticleEffectParameter) parameters;

        assertEquals(null, peParameters.atlasPrefix);
        assertEquals(null, peParameters.imagesDir);
        assertEquals("sample-file", peParameters.atlasFile);
    }

    @Test(expected = ParametersCreateException.class)
    public void when_ParameterFactoryNotFound_Then_ThrowException() {
        parametersFactory.createAssetLoaderParameters(prototype1);
    }
}