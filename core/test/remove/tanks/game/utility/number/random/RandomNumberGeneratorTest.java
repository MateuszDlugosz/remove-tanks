package remove.tanks.game.utility.number.random;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class RandomNumberGeneratorTest {
    @Test
    public void Should_MinValueEquals0_And_MaxValueEquals1_When_GenerateRandomIntegersBetween0And1() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new Random());
        int lowestValue = 0;
        int highestValue = 1;

        for (int i = 0; i < 100000; i++) {
            int randomNumber = randomNumberGenerator.getRandomInt(0, 1);
            if (randomNumber < lowestValue) {
                lowestValue = randomNumber;
            }
            if (randomNumber > highestValue) {
                highestValue = randomNumber;
            }
        }

        assertEquals(lowestValue, 0);
        assertEquals(highestValue, 1);
    }

    @Test
    public void Should_MinValueEquals0_And_MaxValueEquals1_When_GenerateRandomFloatsBetween0And1() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new Random());
        float lowestValue = 0f;
        float highestValue = 1f;

        for (int i = 0; i < 100000; i++) {
            float randomNumber = randomNumberGenerator.getRandomFloat(0f, 1f);
            if (randomNumber < lowestValue) {
                lowestValue = randomNumber;
            }
            if (randomNumber > highestValue) {
                highestValue = randomNumber;
            }
        }

        assertEquals(lowestValue, 0f, 0.001f);
        assertEquals(highestValue, 1f, 0.001f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_When_GivenIntegerMinIsGreaterThanMax() {
        new RandomNumberGenerator(new Random()).getRandomInt(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_When_GivenFloatMinIsGreaterThanMax() {
        new RandomNumberGenerator(new Random()).getRandomFloat(1f, 0f);
    }
}