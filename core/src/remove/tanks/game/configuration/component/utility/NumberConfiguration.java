package remove.tanks.game.configuration.component.utility;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class NumberConfiguration {
    @ComponentName("Random")
    public static final class RandomSupplier extends ComponentSupplier<Random> {
        @Override
        public Random supplyComponent() {
            return new Random();
        }
    }

    @ComponentName("RandomNumberGenerator")
    public static final class RandomNumberGeneratorSupplier extends ComponentSupplier<RandomNumberGenerator> {
        @Override
        public RandomNumberGenerator supplyComponent() {
            return new RandomNumberGenerator(getContext().getComponent("Random", Random.class));
        }
    }
}
