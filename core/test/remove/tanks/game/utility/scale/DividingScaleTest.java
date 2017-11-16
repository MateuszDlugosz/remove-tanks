package remove.tanks.game.utility.scale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class DividingScaleTest {
    @Test(expected = InvalidScaleValueException.class)
    public void when_DividingScaleIsInitializedWithZeroValue_Then_Exception() {
        new DividingScale(0f);
    }

    @Test(expected = InvalidScaleValueException.class)
    public void when_DividingScaleIsInitializedWithNegativeValue_Then_Exception() {
        new DividingScale(-5f);
    }

    @Test
    public void when_DividingScaleInitializedWithCorrectValue_Then_CorrectlyScales() {
        Scale scale = new DividingScale(5f);
        float scaledValue0 = scale.scaleValue(10f);
        float scaledValue1 = scale.scaleValue(7f);

        assertEquals(10f / 5f, scaledValue0, 0.001f);
        assertEquals(7f / 5f, scaledValue1, 0.001f);
    }
}