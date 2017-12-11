package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponentFactory
        implements RegistrableComponentFactory<CameraTrackComponent, CameraTrackComponentPrototype>
{
    private final PositionFactory positionFactory;

    public CameraTrackComponentFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    @Override
    public CameraTrackComponent createComponent(CameraTrackComponentPrototype prototype, Level level, Entity entity) {
        return new CameraTrackComponent(
                positionFactory.createPosition(
                        prototype.getPositionPrototype(),
                        level.getResourceRegistry().getResource(
                                LevelResource.WorldScale.toString(),
                                Scale.class
                        )
                )
        );
    }

    @Override
    public Class<CameraTrackComponentPrototype> getFactoryType() {
        return CameraTrackComponentPrototype.class;
    }
}
