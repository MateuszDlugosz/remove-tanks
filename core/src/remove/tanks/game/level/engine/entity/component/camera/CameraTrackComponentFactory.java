package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentFactory implements SubComponentFactory<CameraTrackComponent, CameraTrackComponentPrefab> {
    private final PositionFactory positionFactory;

    public CameraTrackComponentFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    @Override
    public CameraTrackComponent createComponent(CameraTrackComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new CameraTrackComponent(
                    createPosition(prefab.getPositionPrefab(), registry.getResource(ResourceType.WorldScaleResource, Scale.class)),
                    prefab.getPriority()
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Position createPosition(PositionPrefab prefab, Scale scale) {
        return positionFactory.createPosition(prefab, scale);
    }

    @Override
    public Class<CameraTrackComponentPrefab> getFactoryType() {
        return CameraTrackComponentPrefab.class;
    }
}
