package remove.tanks.game.utility.time;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class TimerTest {
    @Test
    public void when_TimerIsUpdatedEnoughTimes_Then_IsCompleted() {
        Timer timer = new Timer(10f);
        timer.update(10f);

        assertTrue(timer.isCompleted());
    }

    @Test
    public void when_TimerIsUpdatedNotEnoughTimes_Then_IsNotCompleted() {
        Timer timer = new Timer(10f);
        timer.update(1f);
        timer.update(5f);

        assertFalse(timer.isCompleted());
    }
}