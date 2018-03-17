package remove.tanks.game.utility.surface.boundary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundaryPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        BoundaryPrefab prefab = new BoundaryPrefab(0, 1, 2, 3);

        assertEquals(0, prefab.getMinX(), 0.001f);
        assertEquals(1, prefab.getMaxX(), 0.001f);
        assertEquals(2, prefab.getMinY(), 0.001f);
        assertEquals(3, prefab.getMaxY(), 0.001f);
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        BoundaryPrefab prefab = new BoundaryPrefab(0, 1, 2, 3);

        assertEquals("BoundaryPrefab{minX=0.0, maxX=1.0, minY=2.0, maxY=3.0}", prefab.toString());
    }
}