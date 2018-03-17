package remove.tanks.game.utility.surface.position;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrefabXmlReaderTest {
    private static final String POSITION_CORRECT_PREFAB =
            "<position>" +
                    "<x>10</x>" +
                    "<y>4</y>" +
            "</position>";

    private static final String POSITION_INCORRECT_PREFAB =
            "<position>" +
                    "<x>10</x>" +
            "</position>";

    private static final String POSITIONS_CORRECT_PREFAB =
            "<positions>" +
                    "<position>" +
                    "    <x>0</x>" +
                    "    <y>1</y>" +
                    "</position>" +
                    "<position>" +
                    "    <x>10</x>" +
                    "    <y>20</y>" +
                    "</position>" +
            "</positions>";

    private static final String POSITIONS_INCORRECT_PREFAB =
            "<positions>" +
                    "<position>" +
                    "    <x>0</x>" +
                    "    <y>1</y>" +
                    "</position>" +
                    "<position>" +
                    "    <x>10</x>" +
                    "</position>" +
            "</positions>";

    private XmlReader xmlReader;
    private PositionPrefabXmlReader positionPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        positionPrefabXmlReader = new PositionPrefabXmlReader();
    }

    @Test
    public void Should_ReturnPositionPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(POSITION_CORRECT_PREFAB);
        PositionPrefab prefab = positionPrefabXmlReader.readPositionPrefab(element);

        assertEquals(10, prefab.getX(), 0.001f);
        assertEquals(4, prefab.getY(), 0.001f);
    }

    @Test(expected = PositionPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(POSITION_INCORRECT_PREFAB);
        positionPrefabXmlReader.readPositionPrefab(element);
    }

    @Test
    public void Should_ReturnPositionPrefabs_When_ElementsAreCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(POSITIONS_CORRECT_PREFAB);
        List<PositionPrefab> prefabs = positionPrefabXmlReader.readPositionPrefabs(element);

        assertEquals(0, prefabs.get(0).getX(), 0.001f);
        assertEquals(1, prefabs.get(0).getY(), 0.001f);
        assertEquals(10, prefabs.get(1).getX(), 0.001f);
        assertEquals(20, prefabs.get(1).getY(), 0.001f);
    }

    @Test(expected = PositionPrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneOfElementIsIncorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(POSITIONS_INCORRECT_PREFAB);
        positionPrefabXmlReader.readPositionPrefabs(element);
    }
}