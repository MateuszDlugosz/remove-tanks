package remove.tanks.game.utility.counter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class CounterTest {
    @Test
    public void when_CounterIsUpdatedEnoughTimes_Then_IsCompleted() {
        Counter counter = new Counter(3);
        counter.update();
        counter.update();
        counter.update();

        assertTrue(counter.isComplete());
    }

    @Test
    public void when_CounterIsUpdatedNotEnoughTimes_Then_IsNotCompleted() {
        Counter counter = new Counter(3);
        counter.update();
        counter.update();

        assertFalse(counter.isComplete());
    }

    @Test
    public void when_CounterLimitLessThanZero_Then_UpdateInfinity() {
        Counter counter = new Counter(-1);
        counter.update();
        counter.update();

        assertEquals(2, counter.getValue());
        assertFalse(counter.isComplete());
    }
}