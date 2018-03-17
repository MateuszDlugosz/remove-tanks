package remove.tanks.game.utility.surface.position;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        PositionPrefab prefab = new PositionPrefab(10, 20);

        assertEquals(10, prefab.getX(), 0.001f);
        assertEquals(20, prefab.getY(), 0.001f);
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        PositionPrefab prefab = new PositionPrefab(10, 20);

        assertEquals("PositionPrefab{x=10.0, y=20.0}", prefab.toString());
    }
}