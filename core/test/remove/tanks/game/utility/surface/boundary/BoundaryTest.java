package remove.tanks.game.utility.surface.boundary;

import org.junit.Test;
import remove.tanks.game.utility.surface.position.Position;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class BoundaryTest {
    @Test
    public void Should_ReturnAssignedValues() {
        Boundary boundary = new Boundary(0, 1, 2, 3);

        assertEquals(0, boundary.getMinX(), 0.001f);
        assertEquals(1, boundary.getMaxX(), 0.001f);
        assertEquals(2, boundary.getMinY(), 0.001f);
        assertEquals(3, boundary.getMaxY(), 0.001f);
    }

    @Test
    public void Should_ClampBetweenAssignedValues() {
        Boundary boundary = new Boundary(10, 10, 10, 10);

        assertEquals(10, boundary.clampX(20), 0.001f);
        assertEquals(10, boundary.clampX(30), 0.001f);
        assertEquals(10, boundary.clampX(1), 0.001f);

        assertEquals(10, boundary.clampY(20), 0.001f);
        assertEquals(10, boundary.clampY(30), 0.001f);
        assertEquals(10, boundary.clampY(1), 0.001f);
    }

    @Test
    public void Should_ReturnTrue_When_GivenPositionIsInBoundary() {
        Boundary boundary = new Boundary(1, 4, 2, 5);
        Position inBoundariesPosition = new Position(2, 3);

        assertTrue(boundary.isInBoundary(inBoundariesPosition));
    }

    @Test
    public void Should_ReturnFalse_WhenGivenPositionIsNotInBoundary() {
        Boundary boundary = new Boundary(1, 4, 2, 5);
        Position outOfBoundariesPosition = new Position(5, 7);

        assertFalse(boundary.isInBoundary(outOfBoundariesPosition));
    }

    @Test
    public void Should_ReturnCenterOfBoundary() {
        Boundary boundary = new Boundary(2, 4, 3, 6);

        assertEquals(3f, boundary.getCenterPosition().getX(), 0.001f);
        assertEquals(4.5f, boundary.getCenterPosition().getY(), 0.001f);
    }

    @Test
    public void Should_CreateBoundary_By_FactoryMethod() {
        Boundary boundary = Boundary.valueOf(0, 1, 2, 3);

        assertEquals(0, boundary.getMinX(), 0.001f);
        assertEquals(1, boundary.getMaxX(), 0.001f);
        assertEquals(2, boundary.getMinY(), 0.001f);
        assertEquals(3, boundary.getMaxY(), 0.001f);
    }

    @Test(expected = InvalidBoundaryValueException.class)
    public void Should_ThrowException_When_GivenMinXIsGreaterThanMaxX() {
        new Boundary(10, 0, 2, 3);
    }

    @Test(expected = InvalidBoundaryValueException.class)
    public void Should_ThrowException_When_GivenMinYIsGreaterThanMaxY() {
        new Boundary(1, 2, 10, 1);
    }
}
