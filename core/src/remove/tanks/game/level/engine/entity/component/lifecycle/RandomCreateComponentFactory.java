package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.level.utility.create.CreateEntryFactory;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateComponentFactory implements SubComponentFactory<RandomCreateComponent, RandomCreateComponentPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;
    private final CreateEntryFactory createEntryFactory;

    public RandomCreateComponentFactory(
            RandomNumberGenerator randomNumberGenerator,
            CreateEntryFactory createEntryFactory
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.createEntryFactory = createEntryFactory;
    }

    @Override
    public RandomCreateComponent createComponent(RandomCreateComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RandomCreateComponent(
                    prefab.getMinCreateFrequency(),
                    prefab.getMaxCreateFrequency(),
                    createTimer(prefab.getMinCreateFrequency(), prefab.getMaxCreateFrequency()),
                    createCreateEntries(
                            prefab.getCreateEntryPrefabs(),
                            registry.getResource(ResourceType.WorldScaleResource, Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Timer createTimer(float min, float max) {
        return new Timer(randomNumberGenerator.getRandomFloat(min, max));
    }

    private List<CreateEntry> createCreateEntries(List<CreateEntryPrefab> prefabs, Scale scale) {
        return createEntryFactory.createCreateEntries(prefabs, scale);
    }

    @Override
    public Class<RandomCreateComponentPrefab> getFactoryType() {
        return RandomCreateComponentPrefab.class;
    }
}
