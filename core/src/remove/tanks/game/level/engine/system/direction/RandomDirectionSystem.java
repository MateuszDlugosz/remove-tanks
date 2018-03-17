package remove.tanks.game.level.engine.system.direction;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.direction.RandomDirectionComponent;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystem extends IteratingSystem {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomDirectionSystem(int priority, RandomNumberGenerator randomNumberGenerator) {
        super(EntityFamily.RandomDirectionFamily.getFamily(), priority);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RandomDirectionComponent rdc = RandomDirectionComponent.MAPPER.get(entity);
        if (rdc.getTimer().isCompleted()) {
            entity.add(new DirectionComponent(getRandomDirection(rdc.getDirections())));
            entity.add(new RandomDirectionComponent(
                    rdc.getMinChangeDirectionFrequency(),
                    rdc.getMaxChangeDirectionFrequency(),
                    rdc.getDirections(),
                    new Timer(randomNumberGenerator.getRandomFloat(
                            rdc.getMinChangeDirectionFrequency(),
                            rdc.getMaxChangeDirectionFrequency()
                    )))
            );
        } else rdc.getTimer().update(deltaTime);
    }

    private Direction getRandomDirection(List<Direction> directions) {
        return directions.get(randomNumberGenerator.getRandomInt(0, directions.size()-1));
    }
}
