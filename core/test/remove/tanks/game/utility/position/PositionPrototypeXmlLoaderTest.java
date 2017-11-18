package remove.tanks.game.utility.position;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrototypeXmlLoaderTest {
    private static final String CORRECTLY_FORMATTED_XML_ELEMENT =
            "<position>" +
                    "<x>10</x>" +
                    "<y>4</y>" +
            "</position>";
    private static final String INCORRECTLY_FORMATTED_XML_ELEMENT =
            "<position>" +
                    "<x>10</x>" +
            "</position>";

    private XmlReader xmlReader;
    private PositionPrototypeXmlLoader positionPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        positionPrototypeXmlLoader = new PositionPrototypeXmlLoader();
    }

    @Test
    public void when_ElementHasCorrectlyFormat_Then_LoadPositionPrototype() {
        XmlReader.Element element = xmlReader.parse(CORRECTLY_FORMATTED_XML_ELEMENT);
        PositionPrototype positionPrototype = positionPrototypeXmlLoader.loadPositionPrototype(element);

        assertEquals(10, positionPrototype.getX(), 0.001f);
        assertEquals(4, positionPrototype.getY(), 0.001f);
    }

    @Test(expected = PositionPrototypeXmlLoadException.class)
    public void when_ElementHasIncorrectlyFormat_Then_ThrowsExceptions() {
        XmlReader.Element element = xmlReader.parse(INCORRECTLY_FORMATTED_XML_ELEMENT);
        positionPrototypeXmlLoader.loadPositionPrototype(element);
    }
}