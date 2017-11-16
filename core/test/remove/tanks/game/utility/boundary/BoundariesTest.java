package remove.tanks.game.utility.boundary;

import org.junit.Test;
import remove.tanks.game.utility.position.Position;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class BoundariesTest {
    @Test
    public void when_BoundariesMinXIs10AndMaxXIs10_Then_ClampXReturn10() {
        Boundaries boundaries = new Boundaries(10, 10, 20, 20);

        assertEquals(10, boundaries.clampX(20), 0.001f);
        assertEquals(10, boundaries.clampX(30), 0.001f);
        assertEquals(10, boundaries.clampX(1), 0.001f);
    }

    @Test
    public void when_BoundariesMinYIs10AndMaxYIs10_Then_ClampYReturn10() {
        Boundaries boundaries = new Boundaries(20, 20, 10, 10);

        assertEquals(10, boundaries.clampY(20), 0.001f);
        assertEquals(10, boundaries.clampY(30), 0.001f);
        assertEquals(10, boundaries.clampY(1), 0.001f);
    }

    @Test
    public void when_PositionEqualsInBoundaries_Then_ReturnTrue_Else_ReturnFalse() {
        Boundaries boundaries = new Boundaries(1, 4, 2, 5);
        Position inBoundariesPosition = new Position(2, 3);
        Position outOfBoundariesPosition = new Position(5, 7);

        assertTrue(boundaries.isInBoundaries(inBoundariesPosition));
        assertFalse(boundaries.isInBoundaries(outOfBoundariesPosition));
    }

    @Test
    public void when_GetCenterOfBoundaries_Then_ReturnCorrectPosition() {
        Boundaries boundaries = new Boundaries(2, 4, 3, 6);

        assertEquals(3f, boundaries.getCenterPosition().getX(), 0.001f);
        assertEquals(4.5f, boundaries.getCenterPosition().getY(), 0.001f);
    }
}