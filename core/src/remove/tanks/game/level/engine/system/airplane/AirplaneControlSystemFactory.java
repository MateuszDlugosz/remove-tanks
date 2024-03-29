package remove.tanks.game.level.engine.system.airplane;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.surface.boundary.Boundary;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneControlSystemFactory implements SubEntitySystemFactory<AirplaneControlSystem, AirplaneControlSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public AirplaneControlSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public AirplaneControlSystem createEntitySystem(AirplaneControlSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new AirplaneControlSystem(
                    prefab.getPriority(),
                    randomNumberGenerator,
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class),
                    registry.getResource(ResourceType.TiledMapBoundaryResource, Boundary.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<AirplaneControlSystemPrefab> getFactoryType() {
        return AirplaneControlSystemPrefab.class;
    }
}
