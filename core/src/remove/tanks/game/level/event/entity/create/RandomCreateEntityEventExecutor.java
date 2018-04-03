package remove.tanks.game.level.event.entity.create;

import remove.tanks.game.level.engine.entity.EntityController;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateEntityEventExecutor implements SubEventExecutor<RandomCreateEntityEvent> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomCreateEntityEventExecutor(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void executeEvent(RandomCreateEntityEvent event, ResourceRegistry registry) {
        try {
            int randomIndex = randomNumberGenerator.getRandomInt(0, event.getCreateEntries().size() - 1);
            CreateEntry entry = event.getCreateEntries().get(randomIndex);
            registry.getResource(ResourceType.EntityControllerResource,
                    EntityController.class).createEntity(entry.getPrefabCode(), entry.getPosition(), registry);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<RandomCreateEntityEvent> getExecutorType() {
        return RandomCreateEntityEvent.class;
    }
}
