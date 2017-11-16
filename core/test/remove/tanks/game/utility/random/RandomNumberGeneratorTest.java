package remove.tanks.game.utility.random;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class RandomNumberGeneratorTest {
    @Test
    public void when_RandomNumberGenerateIntFrom0To10_Then_LowestValueIs0_And_HighestValueIs10() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new Random());
        int lowestValue = 0;
        int highestValue = 10;

        for (int i = 0; i < 100000; i++) {
            int randomNumber = randomNumberGenerator.getRandomInt(0, 10);
            if (randomNumber < lowestValue) {
                lowestValue = randomNumber;
            }
            if (randomNumber > highestValue) {
                highestValue = randomNumber;
            }
        }

        assertEquals(lowestValue, 0);
        assertEquals(highestValue, 10);
    }

    @Test
    public void when_RandomNumberGenerateFloatFrom0To10_Then_LowestValueIs0_And_HighestValueIs10() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new Random());
        float lowestValue = 0f;
        float highestValue = 10f;

        for (int i = 0; i < 100000; i++) {
            float randomNumber = randomNumberGenerator.getRandomFloat(0f, 10f);
            if (randomNumber < lowestValue) {
                lowestValue = randomNumber;
            }
            if (randomNumber > highestValue) {
                highestValue = randomNumber;
            }
        }

        assertEquals(lowestValue, 0f, 0.001f);
        assertEquals(highestValue, 10f, 0.001f);
    }
}