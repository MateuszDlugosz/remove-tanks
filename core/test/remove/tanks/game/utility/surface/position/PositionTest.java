package remove.tanks.game.utility.surface.position;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionTest {
    @Test
    public void Should_ReturnAssignedValues() {
        Position position = new Position(10, 20);

        assertEquals(10, position.getX(), 0.001f);
        assertEquals(20, position.getY(), 0.001f);
    }

    @Test
    public void Should_ReturnCorrectlySummedPosition() {
        Position position0 = new Position(0, 1);
        Position position1 = new Position(10, 2);

        Position newPosition0 = position0.sum(position1);

        assertEquals(10, newPosition0.getX(), 0.001f);
        assertEquals(3, newPosition0.getY(), 0.001f);
    }

    @Test
    public void Should_ReturnVector2WithValuesAssignedToPosition() {
        Position position0 = Position.POSITION_ZERO;
        Position position1 = new Position(10, 5);

        assertEquals(0, position0.getAsVector2().x, 0.001f);
        assertEquals(0, position0.getAsVector2().y, 0.001f);
        assertEquals(10, position1.getAsVector2().x, 0.001f);
        assertEquals(5, position1.getAsVector2().y, 0.001f);
    }

    @Test
    public void Should_CreatePosition_By_FactoryMethod() {
        Position position0 = Position.valueOf(10, 20);

        assertEquals(10, position0.getX(), 0.001f);
        assertEquals(20, position0.getY(), 0.001f);
    }
}
