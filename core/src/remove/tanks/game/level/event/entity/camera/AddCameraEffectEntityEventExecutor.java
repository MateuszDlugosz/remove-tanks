package remove.tanks.game.level.event.entity.camera;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.system.camera.CameraEffectSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

public final class AddCameraEffectEntityEventExecutor implements SubEventExecutor<AddCameraEffectEntityEvent> {
    @Override
    public void executeEvent(AddCameraEffectEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(CameraEffectSystem.class)).ifPresent(s -> {
                        if (registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class)
                                .getCameraBoundaries().isInBoundary(PhysicsComponent.MAPPER.get(
                                        event.getEntity()).getPosition()))
                        {
                            s.addCameraEffect(event.getCameraEffect());
                        }
            });
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddCameraEffectEntityEvent> getExecutorType() {
        return AddCameraEffectEntityEvent.class;
    }
}
