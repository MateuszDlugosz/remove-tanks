package remove.tanks.game.level.event.entity.sound;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEntityEventExecutor implements SubEventExecutor<PlaySoundEntityEvent> {
    @Override
    public void executeEvent(PlaySoundEntityEvent event, ResourceRegistry registry) {
        try {
            if (registry.getResource(ResourceType.GameCameraResource, Game2DCamera.class)
                    .getCameraBoundaries().isInBoundary(PhysicsComponent.MAPPER.get(event.getEntity()).getPosition()))
            {
                registry.getResource(ResourceType.ExternalEventBusResource, EventBus.class)
                        .post(new PlaySoundEvent(event.getSoundChannelName(), event.getSound()));
            }
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<PlaySoundEntityEvent> getExecutorType() {
        return PlaySoundEntityEvent.class;
    }
}
