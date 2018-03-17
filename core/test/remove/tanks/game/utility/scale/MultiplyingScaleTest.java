package remove.tanks.game.utility.scale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class MultiplyingScaleTest {
    @Test
    public void Should_ReturnCorrectlyScaledValues() {
        Scale scale = new MultiplyingScale(5f);
        float scaledValue0 = scale.scaleValue(10f);
        float scaledValue1 = scale.scaleValue(7f);

        assertEquals(10f * 5f, scaledValue0, 0.001f);
        assertEquals(7f * 5f, scaledValue1, 0.001f);
    }
}
