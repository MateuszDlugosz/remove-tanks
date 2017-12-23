package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class ParticleEffectParametersFactoryTest extends LibGDXTest {
    private static final String PARTICLE_EFFECT_PARAMETER_PROTOTYPE_FILE
            = "asset/parameter/parameters-correct-prototype.xml";

    private XmlReader xmlReader;
    private ParametersPrototypeXmlLoader parametersPrototypeXmlLoader;
    private ParametersFactory parametersFactory;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        parametersPrototypeXmlLoader = new ParametersPrototypeXmlLoader();
        parametersFactory = new ParametersFactory();
        parametersFactory.registerFactory(new ParticleEffectParametersFactory());
    }

    @Test
    public void when_ParticleEffectParametersIsCorrectlyFormatted_Then_CreateParticleEffectParameter() {
        ParametersPrototype prototype = parametersPrototypeXmlLoader.loadParametersPrototype(
                xmlReader.parse(Gdx.files.internal(PARTICLE_EFFECT_PARAMETER_PROTOTYPE_FILE)));
        AssetLoaderParameters parameters = parametersFactory.createAssetLoaderParameters(prototype);
        ParticleEffectLoader.ParticleEffectParameter peParameter
                = (ParticleEffectLoader.ParticleEffectParameter) parameters;

        assertEquals("testPrefix", peParameter.atlasPrefix);
        assertEquals("remove/tanks/game/graphic/textures/atlases/test-atlas-file.pack",
                peParameter.atlasFile);
        assertTrue(Gdx.files.internal("remove/tanks/game/graphic/textures/images")
                .equals(peParameter.imagesDir));
    }
}