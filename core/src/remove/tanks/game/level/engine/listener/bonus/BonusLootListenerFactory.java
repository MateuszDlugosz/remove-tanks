package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootListenerFactory
        implements RegistrableEntityListenerFactory<BonusLootListener, BonusLootListenerPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public BonusLootListenerFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public BonusLootListener createEntityListener(BonusLootListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new BonusLootListener(
                randomNumberGenerator,
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                engine,
                prototype.getChance(),
                prototype.getPrototypeCodes().stream()
                        .map(c -> registry.getResource(LevelResource.EntityPrototypeRepository.toString(),
                                EntityPrototypeRepository.class).getPrototype(c))
                        .collect(Collectors.toList()),
                prototype.getPriority()
        );
    }

    @Override
    public Class<BonusLootListenerPrototype> getFactoryType() {
        return BonusLootListenerPrototype.class;
    }
}
