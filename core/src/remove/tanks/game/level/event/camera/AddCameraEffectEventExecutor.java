package remove.tanks.game.level.event.camera;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.camera.CameraEffectSystem;
import remove.tanks.game.level.event.RegistrableEventExecutor;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventExecutor
        implements RegistrableEventExecutor<AddCameraEffectEvent>
{
    @Override
    public void executeEvent(AddCameraEffectEvent event, Level level) {
        Optional.ofNullable(level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getSystem(CameraEffectSystem.class)).ifPresent(
                        s -> s.addCameraEffect(event.getCameraEffect())
        );
    }

    @Override
    public Class<AddCameraEffectEvent> getExecutorType() {
        return AddCameraEffectEvent.class;
    }
}
