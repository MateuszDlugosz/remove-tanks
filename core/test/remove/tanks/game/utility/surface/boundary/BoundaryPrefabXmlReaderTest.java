package remove.tanks.game.utility.surface.boundary;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundaryPrefabXmlReaderTest {
    private static final String BOUNDARY_CORRECT_PREFAB =
            "<boundary>" +
                    "<minX>0</minX>" +
                    "<maxX>10</maxX>" +
                    "<minY>2</minY>" +
                    "<maxY>80</maxY>" +
            "</boundary>";

    private static final String BOUNDARY_INCORRECT_PREFAB =
            "<boundary>" +
                    "<minX>0</minX>" +
                    "<minY>2</minY>" +
            "</boundary>";

    private static final String BOUNDARIES_CORRECT_PREFAB =
            "<boundaries>" +
                    "<boundary>" +
                    "    <minX>0</minX>" +
                    "    <maxX>1</maxX>" +
                    "    <minY>2</minY>" +
                    "    <maxY>3</maxY>" +
                    "</boundary>" +
                    "<boundary>" +
                    "    <minX>10</minX>" +
                    "    <maxX>20</maxX>" +
                    "    <minY>30</minY>" +
                    "    <maxY>40</maxY>" +
                    "</boundary>" +
            "</boundaries>";

    private static final String BOUNDARIES_INCORRECT_PREFAB =
            "<boundaries>" +
                    "<boundary>" +
                    "    <minX>0</minX>" +
                    "    <maxX>1</maxX>" +
                    "    <minY>2</minY>" +
                    "    <maxY>3</maxY>" +
                    "</boundary>" +
                    "<boundary>" +
                    "    <minX>10</minX>" +
                    "</boundary>" +
            "</boundaries>";

    private XmlReader xmlReader;
    private BoundaryPrefabXmlReader boundaryPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        boundaryPrefabXmlReader = new BoundaryPrefabXmlReader();
    }

    @Test
    public void Should_ReturnBoundaryPrefab_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(BOUNDARY_CORRECT_PREFAB);
        BoundaryPrefab prefab = boundaryPrefabXmlReader.readBoundaryPrefab(element);

        assertEquals(0, prefab.getMinX(), 0.001f);
        assertEquals(10, prefab.getMaxX(), 0.001f);
        assertEquals(2, prefab.getMinY(), 0.001f);
        assertEquals(80, prefab.getMaxY(), 0.001f);
    }

    @Test(expected = BoundaryPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(BOUNDARY_INCORRECT_PREFAB);

        boundaryPrefabXmlReader.readBoundaryPrefab(element);
    }

    @Test
    public void Should_ReturnBoundariesPrefabs_When_ElementIsCorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(BOUNDARIES_CORRECT_PREFAB);
        List<BoundaryPrefab> prefabs = boundaryPrefabXmlReader.readBoundaryPrefabs(element);

        assertEquals(0, prefabs.get(0).getMinX(), 0.001f);
        assertEquals(1, prefabs.get(0).getMaxX(), 0.001f);
        assertEquals(2, prefabs.get(0).getMinY(), 0.001f);
        assertEquals(3, prefabs.get(0).getMaxY(), 0.001f);

        assertEquals(10, prefabs.get(1).getMinX(), 0.001f);
        assertEquals(20, prefabs.get(1).getMaxX(), 0.001f);
        assertEquals(30, prefabs.get(1).getMinY(), 0.001f);
        assertEquals(40, prefabs.get(1).getMaxY(), 0.001f);
    }

    @Test(expected = BoundaryPrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneOfElementIsIncorrectlyFormatted() {
        XmlReader.Element element = xmlReader.parse(BOUNDARIES_INCORRECT_PREFAB);

        boundaryPrefabXmlReader.readBoundaryPrefab(element);
    }
}
