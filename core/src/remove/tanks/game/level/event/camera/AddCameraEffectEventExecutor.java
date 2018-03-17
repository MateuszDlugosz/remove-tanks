package remove.tanks.game.level.event.camera;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.camera.CameraEffectSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AddCameraEffectEventExecutor implements SubEventExecutor<AddCameraEffectEvent> {
    @Override
    public void executeEvent(AddCameraEffectEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(CameraEffectSystem.class)).ifPresent(s -> s.addCameraEffect(event.getCameraEffect()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddCameraEffectEvent> getExecutorType() {
        return AddCameraEffectEvent.class;
    }
}
