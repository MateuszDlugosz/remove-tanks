package remove.tanks.game.utility.scale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class DividingScaleTest {
    @Test(expected = InvalidScaleValueException.class)
    public void Should_ThrowException_When_GivenScaleValueIsZero() {
        new DividingScale(0f);
    }

    @Test(expected = InvalidScaleValueException.class)
    public void Should_ThrowException_When_GivenScaleValueIsNegativeNumber() {
        new DividingScale(-5f);
    }

    @Test
    public void Should_ReturnCorrectlyScaledValues() {
        Scale scale = new DividingScale(5f);
        float scaledValue0 = scale.scaleValue(10f);
        float scaledValue1 = scale.scaleValue(7f);

        assertEquals(10f / 5f, scaledValue0, 0.001f);
        assertEquals(7f / 5f, scaledValue1, 0.001f);
    }
}
