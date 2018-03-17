package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ParametersPrefabXmlReaderTest {
    private static final String CORRECT_PARAMETERS_PREFAB =
            "<parameters className=\"com.badlogic.gdx.assets.loaders.ParticleEffectLoader$ParticleEffectParameter\">" +
                    "<parameter name=\"atlasFile\">graphics/textures/atlases/test-atlas-file.pack</parameter>" +
                    "<parameter name=\"atlasPrefix\">testPrefix</parameter>" +
                    "<parameter name=\"imagesDir\">graphics/textures/images</parameter>" +
            "</parameters>";
    private static final String INCORRECT_PARAMETERS_PREFAB =
            "<parameters></parameters>";

    private XmlReader xmlReader;
    private ParametersPrefabXmlReader parametersPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        parametersPrefabXmlReader = new ParametersPrefabXmlReader();
    }

    @Test
    public void Should_ReturnParameterPrefab_When_GivenElementIsCorrectlyFormatted() {
        ParametersPrefab prefab = parametersPrefabXmlReader.readParametersPrefab(
                xmlReader.parse(CORRECT_PARAMETERS_PREFAB));

        assertEquals("graphics/textures/atlases/test-atlas-file.pack",
                prefab.getParameters().get("atlasFile"));
    }

    @Test(expected = ParametersPrefabXmlReadException.class)
    public void Should_ThrowException_When_GivenElementIsIncorrectlyFormatted() {
        parametersPrefabXmlReader.readParametersPrefab(
                xmlReader.parse(INCORRECT_PARAMETERS_PREFAB));
    }
}
