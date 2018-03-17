package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.lifecycle.RandomCreateComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

import java.util.Collections;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateSystem extends IteratingSystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;

    public RandomCreateSystem(int priority, EventBus eventBus, RandomNumberGenerator randomNumberGenerator) {
        super(EntityFamily.RandomCreateFamily.getFamily(), priority);
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RandomCreateComponent rcc = RandomCreateComponent.MAPPER.get(entity);
        if (rcc.getTimer().isCompleted()) {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            CreateEntry createEntry = rcc.getCreateEntries()
                    .get(randomNumberGenerator.getRandomInt(0, rcc.getCreateEntries().size() - 1));
            eventBus.post(new CreateEvent(Collections.singletonList(
                    new CreateEntry(createEntry.getPrefabCode(), pc.getPosition().sum(createEntry.getPosition())))));
            entity.add(new RandomCreateComponent(
                    rcc.getMinCreateFrequency(),
                    rcc.getMaxCreateFrequency(),
                    new Timer(randomNumberGenerator.getRandomFloat(
                            rcc.getMinCreateFrequency(), rcc.getMaxCreateFrequency())),
                    rcc.getCreateEntries()
            ));
        } else {
            rcc.getTimer().update(deltaTime);
        }
    }
}
