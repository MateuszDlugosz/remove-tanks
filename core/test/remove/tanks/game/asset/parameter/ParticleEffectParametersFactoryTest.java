package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class ParticleEffectParametersFactoryTest extends LibGDXTest {
    private static final String CORRECT_PARAMETERS_PREFAB =
            "<parameters className=\"com.badlogic.gdx.assets.loaders.ParticleEffectLoader$ParticleEffectParameter\">" +
                    "<parameter name=\"atlasFile\">graphics/textures/atlases/test-atlas-file.pack</parameter>" +
                    "<parameter name=\"atlasPrefix\">testPrefix</parameter>" +
                    "<parameter name=\"imagesDir\">graphics/textures/images</parameter>" +
            "</parameters>";

    private XmlReader xmlReader;
    private ParametersPrefabXmlReader parametersPrefabXmlReader;
    private ParametersFactory parametersFactory;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        parametersPrefabXmlReader = new ParametersPrefabXmlReader();
        parametersFactory = new ParametersFactory(
                new SubParametersFactory[] {
                        new ParticleEffectParametersFactory()
                }
        );
    }

    @Test
    public void Should_ReturnParticleEffectParameter_When_GivenElementIsCorrectlyFormatted() {
        ParametersPrefab prefab = parametersPrefabXmlReader.readParametersPrefab(
                xmlReader.parse(CORRECT_PARAMETERS_PREFAB));
        AssetLoaderParameters parameters = parametersFactory.createAssetLoaderParameters(prefab);
        ParticleEffectLoader.ParticleEffectParameter peParameter
                = (ParticleEffectLoader.ParticleEffectParameter) parameters;

        assertEquals("testPrefix", peParameter.atlasPrefix);
        assertEquals("graphics/textures/atlases/test-atlas-file.pack",
                peParameter.atlasFile);
        assertTrue(Gdx.files.internal("graphics/textures/images")
                .equals(peParameter.imagesDir));
    }
}
