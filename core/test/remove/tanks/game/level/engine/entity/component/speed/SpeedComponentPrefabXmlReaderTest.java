package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class SpeedComponentPrefabXmlReaderTest {
    private static final String COMPONENT_CORRECT_ELEMENT =
            "<component type=\"SpeedComponent\">" +
                    "<speed>1.1</speed>" +
            "</component>";

    private static final String COMPONENT_INCORRECT_ELEMENT =
            "<component type=\"SpeedComponent\">" +
            "</component>";

    private XmlReader xmlReader;
    private SpeedComponentPrefabXmlReader speedComponentPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        speedComponentPrefabXmlReader = new SpeedComponentPrefabXmlReader();
    }

    @Test
    public void Should_ReturnSpeedComponentPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(COMPONENT_CORRECT_ELEMENT);
        SpeedComponentPrefab prefab = speedComponentPrefabXmlReader.readComponentPrefab(element);

        assertEquals(1.1f, prefab.getSpeed(), 0.001f);
    }

    @Test(expected = ComponentPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        speedComponentPrefabXmlReader.readComponentPrefab(xmlReader.parse(COMPONENT_INCORRECT_ELEMENT));
    }
}