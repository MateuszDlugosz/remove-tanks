package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ParametersPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_PARAMETER_PROTOTYPE_FILE
            = "asset/parameter/parameters-correct-prototype.xml";
    private static final String INCORRECT_PARAMETER_PROTOTYPE_FILE
            = "asset/parameter/parameters-incorrect-prototype.xml";

    private XmlReader xmlReader;
    private ParametersPrototypeXmlLoader parametersPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        parametersPrototypeXmlLoader = new ParametersPrototypeXmlLoader();
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadParameterPrototype() {
        ParametersPrototype prototype = parametersPrototypeXmlLoader.loadParametersPrototype(
                xmlReader.parse(Gdx.files.internal(CORRECT_PARAMETER_PROTOTYPE_FILE)));

        assertEquals("graphic/textures/atlases/test-atlas-file.pack",
                prototype.getParameters().get("atlasFile"));
    }

    @Test(expected = ParametersPrototypeXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        parametersPrototypeXmlLoader.loadParametersPrototype(
                xmlReader.parse(Gdx.files.internal(INCORRECT_PARAMETER_PROTOTYPE_FILE)));
    }
}