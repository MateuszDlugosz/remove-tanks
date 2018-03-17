package remove.tanks.game.utility.number.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mateusz Długosz
 */
public final class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator(Random random) {
        this.random = random;
    }

    public int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public float getRandomFloat(float min, float max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }
        return random.nextFloat() * (max - min) + min;
    }
}
