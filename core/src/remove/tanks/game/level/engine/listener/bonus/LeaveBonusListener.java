package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.listener.AbstractEntityListener;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusListener extends AbstractEntityListener {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private final List<String> prefabCodes;
    private final float chance;

    public LeaveBonusListener(
            int priority,
            Engine engine,
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus,
            List<String> prefabCodes,
            float chance
    ) {
        super(priority, EntityFamily.LeaveBonusFamily.getFamily(), engine);
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.prefabCodes = prefabCodes;
        this.chance = chance;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        if (randomNumberGenerator.getRandomInt(1, 100) <= chance) {
            CreateEntry createEntry = new CreateEntry(
                    prefabCodes.get(randomNumberGenerator.getRandomInt(0, prefabCodes.size() - 1)),
                    PhysicsComponent.MAPPER.get(entity).getPosition()
            );
            List<CreateEntry> createEntries = new ArrayList<>();
            createEntries.add(createEntry);
            eventBus.post(new CreateEvent(createEntries));
        }
    }
}
