package remove.tanks.game.utility.position;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionTest {
    @Test
    public void when_SumTwoPositions_Then_NewOneReturnCorrectValues() {
        Position position0 = new Position(0, 1);
        Position position1 = new Position(10, 2);
        Position position2 = new Position(9, 5);

        Position newPosition0 = position0.sum(position1);
        Position newPosition1 = position1.sum(position2);
        Position newPosition2 = position2.sum(position0);

        assertEquals(10, newPosition0.getX(), 0.001f);
        assertEquals(3, newPosition0.getY(), 0.001f);
        assertEquals(19, newPosition1.getX(), 0.001f);
        assertEquals(7, newPosition1.getY(), 0.001f);
        assertEquals(9, newPosition2.getX(), 0.001f);
        assertEquals(6, newPosition2.getY(), 0.001f);
    }
}