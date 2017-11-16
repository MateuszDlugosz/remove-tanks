package remove.tanks.game.utility.boundary;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundariesPrototypeXmlLoaderTest {
    private static final String CORRECTLY_FORMATTED_XML_ELEMENT =
            "<boundaries>" +
                    "<minX>1</minX>" +
                    "<maxX>4</maxX>" +
                    "<minY>2</minY>" +
                    "<maxY>5</maxY>" +
            "</boundaries>";

    private static final String INCORRECTLY_FORMATTED_XML_ELEMENT =
            "<boundaries>" +
                    "<minX>9</minX>" +
            "</boundaries>";

    private XmlReader xmlReader;
    private BoundariesPrototypeXmlLoader boundariesPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        boundariesPrototypeXmlLoader = new BoundariesPrototypeXmlLoader();
    }

    @Test
    public void when_ElementHasCorrectlyFormat_Then_LoadBoundariesPrototype() {
        XmlReader.Element element = xmlReader.parse(CORRECTLY_FORMATTED_XML_ELEMENT);
        BoundariesPrototype prototype = boundariesPrototypeXmlLoader.loadBoundariesPrototype(element);

        assertEquals(1, prototype.getMinX(), 0.001f);
        assertEquals(4, prototype.getMaxX(), 0.001f);
        assertEquals(2, prototype.getMinY(), 0.001f);
        assertEquals(5, prototype.getMaxY(), 0.001f);
    }

    @Test(expected = BoundariesPrototypeXmlLoadException.class)
    public void when_ElementHasIncorrectlyFormat_Then_ThrowsExceptions() {
        XmlReader.Element element = xmlReader.parse(INCORRECTLY_FORMATTED_XML_ELEMENT);

        boundariesPrototypeXmlLoader.loadBoundariesPrototype(element);
    }
}