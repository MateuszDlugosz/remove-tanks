package remove.tanks.game.level.utility.direction;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class DirectionXmlReaderTest {
    private static final String DIRECTION_CORRECT_ELEMENT =
            "<direction>Left</direction>";

    private static final String DIRECTION_INCORRECT_ELEMENT =
            "<direction>UnknownDirection</direction>";

    private static final String DIRECTIONS_CORRECT_ELEMENT =
            "<directions>" +
                    "<direction>Left</direction>" +
                    "<direction>Right</direction>" +
            "</directions>";

    private static final String DIRECTIONS_INCORRECT_ELEMENT =
            "<directions>" +
                    "<direction>Left</direction>" +
                    "<direction>UnknownDirection</direction>" +
            "</directions>";

    private XmlReader xmlReader;
    private DirectionXmlReader directionXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        directionXmlReader = new DirectionXmlReader();
    }

    @Test
    public void Should_ReturnDirection() {
        assertEquals(Direction.Left, directionXmlReader.readDirection(xmlReader.parse(DIRECTION_CORRECT_ELEMENT)));
    }

    @Test(expected = DirectionXmlReadException.class)
    public void Should_ThrowException_When_DirectionIsNotInEnum() {
        directionXmlReader.readDirection(xmlReader.parse(DIRECTION_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnDirections() {
        List<Direction> directions = directionXmlReader.readDirections(xmlReader.parse(DIRECTIONS_CORRECT_ELEMENT));

        assertEquals(2 , directions.size());
        assertEquals(Direction.Left, directions.get(0));
        assertEquals(Direction.Right, directions.get(1));
    }

    @Test(expected = DirectionXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneDirectionIsNotInEnum() {
        directionXmlReader.readDirections(xmlReader.parse(DIRECTIONS_INCORRECT_ELEMENT));
    }
}