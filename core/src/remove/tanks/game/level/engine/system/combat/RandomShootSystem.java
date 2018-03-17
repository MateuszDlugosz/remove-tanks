package remove.tanks.game.level.engine.system.combat;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.combat.AutoShootComponent;
import remove.tanks.game.level.engine.entity.component.combat.RandomShootComponent;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootSystem extends IteratingSystem {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomShootSystem(int priority, RandomNumberGenerator randomNumberGenerator) {
        super(EntityFamily.RandomShootFamily.getFamily(), priority);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RandomShootComponent rsc = RandomShootComponent.MAPPER.get(entity);
        if (rsc.getTimer().isCompleted()) {
            entity.add(new AutoShootComponent());
            entity.add(new RandomShootComponent(
                    rsc.getMinShootFrequency(),
                    rsc.getMaxShootFrequency(),
                    new Timer(randomNumberGenerator.getRandomFloat(
                            rsc.getMinShootFrequency(),
                            rsc.getMaxShootFrequency()
                    ))
            ));
        } else rsc.getTimer().update(deltaTime);
    }
}
