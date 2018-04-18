package remove.tanks.game.utility.number.counter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class CounterTest {
    @Test
    public void Should_ReturnTrue_When_CounterWasUpdatedEnoughNumberOfTimes() {
        Counter counter = new Counter(3);
        counter.update();
        counter.update();
        counter.update();

        assertTrue(counter.isCompleted());
    }

    @Test
    public void Should_ReturnFalse_When_CounterWasNotUpdatedEnoughNumberOfTimes() {
        Counter counter = new Counter(3);
        counter.update();
        counter.update();

        assertFalse(counter.isCompleted());
    }

    @Test
    public void Should_AlwaysReturnFalse_When_CounterWasInitializedByNegativeValue() {
        Counter counter = new Counter(-1);
        counter.update();
        counter.update();

        assertEquals(2, counter.getValue());
        assertFalse(counter.isCompleted());
    }
}