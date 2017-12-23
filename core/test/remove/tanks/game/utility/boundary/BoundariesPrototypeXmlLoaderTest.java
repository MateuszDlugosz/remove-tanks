package remove.tanks.game.utility.boundary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundariesPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_BOUNDARIES_PROTOTYPE_FILE
            = "utility/boundaries/boundaries-correct-prototype.xml";
    private static final String INCORRECT_BOUNDARIES_PROTOTYPE_FILE
            = "utility/boundaries/boundaries-incorrect-prototype.xml";

    private XmlReader xmlReader;
    private BoundariesPrototypeXmlLoader boundariesPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        boundariesPrototypeXmlLoader = new BoundariesPrototypeXmlLoader();
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadBoundariesPrototype() {
        XmlReader.Element element = xmlReader.parse(Gdx.files.internal(CORRECT_BOUNDARIES_PROTOTYPE_FILE));
        BoundariesPrototype prototype = boundariesPrototypeXmlLoader.loadBoundariesPrototype(element);

        assertEquals(0, prototype.getMinX(), 0.001f);
        assertEquals(10, prototype.getMaxX(), 0.001f);
        assertEquals(2, prototype.getMinY(), 0.001f);
        assertEquals(80, prototype.getMaxY(), 0.001f);
    }

    @Test(expected = BoundariesPrototypeXmlLoadException.class)
    public void when_ElementHasIncorrectlyFormatted_Then_ThrowException() {
        XmlReader.Element element = xmlReader.parse(Gdx.files.internal(INCORRECT_BOUNDARIES_PROTOTYPE_FILE));
        BoundariesPrototype prototype = boundariesPrototypeXmlLoader.loadBoundariesPrototype(element);
    }
}