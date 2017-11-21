package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototype;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootListener extends ExtendedEntityListener {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private final int chance;
    private final List<EntityPrototype> availableBonuses;

    public BonusLootListener(
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus,
            Engine engine,
            int chance,
            List<EntityPrototype> availableBonuses,
            int priority
    ) {
        super(priority, EntityFamily.BonusLootFamily.getFamily(), engine);
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.chance = chance;
        this.availableBonuses = availableBonuses;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        if (availableBonuses.size() > 0) {
            if (randomNumberGenerator.getRandomInt(1, 100) <= chance) {
                PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
                eventBus.post(new SpawnEntityEvent(
                        availableBonuses.get(randomNumberGenerator.getRandomInt(
                                0, availableBonuses.size()-1
                        )),
                        pc.getPosition())
                );
            }
        }
    }
}
