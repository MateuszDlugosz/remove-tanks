package remove.tanks.game.utility.position;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_POSITION_PROTOTYPE_FILE
            = "prototypes/utility/position/position-correct-prototype.xml";
    private static final String INCORRECT_POSITION_PROTOTYPE_FILE
            = "prototypes/utility/position/position-incorrect-prototype.xml";

    private XmlReader xmlReader;
    private PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        positionPrototypeXmlLoader = new PositionPrototypeXmlLoader();
    }

    @Test
    public void when_ElementHasCorrectlyFormat_Then_LoadPositionPrototype() {
        XmlReader.Element element = xmlReader.parse(Gdx.files.internal(CORRECT_POSITION_PROTOTYPE_FILE));
        PositionPrototype positionPrototype = positionPrototypeXmlLoader.loadPositionPrototype(element);

        assertEquals(10, positionPrototype.getX(), 0.001f);
        assertEquals(4, positionPrototype.getY(), 0.001f);
    }

    @Test(expected = PositionPrototypeXmlLoadException.class)
    public void when_ElementHasIncorrectlyFormat_Then_ThrowsExceptions() {
        XmlReader.Element element = xmlReader.parse(Gdx.files.internal(INCORRECT_POSITION_PROTOTYPE_FILE));
        positionPrototypeXmlLoader.loadPositionPrototype(element);
    }
}