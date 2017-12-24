package remove.tanks.game.level.engine.system.spawn;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnSystemFactory
        implements RegistrableEntitySystemFactory<RandomSpawnSystem, RandomSpawnSystemPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomSpawnSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomSpawnSystem createEntitySystem(RandomSpawnSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new RandomSpawnSystem(
                    prototype.getPriority(),
                    randomNumberGenerator,
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    resourceRegistry.getResource(LevelResource.EntityPrototypeRepository.toString(), EntityPrototypeRepository.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<RandomSpawnSystemPrototype> getFactoryType() {
        return RandomSpawnSystemPrototype.class;
    }
}
