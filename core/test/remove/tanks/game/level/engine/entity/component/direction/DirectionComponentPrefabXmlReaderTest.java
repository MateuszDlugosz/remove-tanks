package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.level.utility.direction.DirectionXmlReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class DirectionComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"DirectionComponent\">" +
                    "<direction>Left</direction>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"DirectionComponent\">" +
            "</component>";

    private XmlReader xmlReader;
    private DirectionComponentPrefabXmlReader directionComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        directionComponentPrefabXmlReader = new DirectionComponentPrefabXmlReader(
                new DirectionXmlReader()
        );
    }

    @Test
    public void Should_ReturnDirectionComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        DirectionComponentPrefab prefab = directionComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(Direction.Left, prefab.getDirection());
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        directionComponentPrefabXmlReader.readComponentPrefab(xmlReader.parse(COMPONENT_INCORRECT_ELEMENT));
    }
}