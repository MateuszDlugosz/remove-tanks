package remove.tanks.game.level.engine.system.artillery;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.boundary.Boundary;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryControlSystemFactory implements SubEntitySystemFactory<ArtilleryControlSystem, ArtilleryControlSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public ArtilleryControlSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public ArtilleryControlSystem createEntitySystem(ArtilleryControlSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new ArtilleryControlSystem(
                    prefab.getPriority(),
                    randomNumberGenerator,
                    registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    createTimer(prefab.getFrequency()),
                    prefab.getEntityPrefabCodes()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Timer createTimer(float frequency) {
        return new Timer(frequency);
    }

    @Override
    public Class<ArtilleryControlSystemPrefab> getFactoryType() {
        return ArtilleryControlSystemPrefab.class;
    }
}
