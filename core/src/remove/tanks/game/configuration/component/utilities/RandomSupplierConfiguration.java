package remove.tanks.game.configuration.component.utilities;

import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class RandomSupplierConfiguration {
    @ComponentName("RandomNumberGenerator")
    public static final class RandomNumberGeneratorSupplier extends ComponentSupplier<RandomNumberGenerator> {
        @Override
        public RandomNumberGenerator supplyComponent() {
            return new RandomNumberGenerator(new Random());
        }
    }
}
